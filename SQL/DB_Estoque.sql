-- phpMyAdmin SQL Dump
-- version 5.1.1-2.fc35
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 21-Nov-2021 às 22:37
-- Versão do servidor: 8.0.27
-- versão do PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `DB_Estoque`
--
CREATE DATABASE IF NOT EXISTS `DB_Estoque` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `DB_Estoque`;

DELIMITER $$
--
-- Procedimentos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `AD_EntradaProduto` (IN `idProduto` INT(10), IN `qtdeEntrada` INT(10), IN `ValoUnitario` DOUBLE)  INSERT INTO estoque(estoque.id_produto, estoque.qtde, estoque.valor_unitario)VALUES(idProduto, qtdeEntrada,ValoUnitario)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AD_SaidaProduto` (IN `idProduto` INT(10), IN `qtdeSaida` INT(10), IN `ValoUnitario` DOUBLE)  INSERT INTO estoque(estoque.id_produto, estoque.qtde, estoque.valor_unitario)VALUES(idProduto, qtdeSaida * -1,ValoUnitario)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `entrada_produto`
--

CREATE TABLE IF NOT EXISTS `entrada_produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_produto` int DEFAULT NULL,
  `qtde` int DEFAULT NULL,
  `valor_unitario` decimal(9,2) DEFAULT '0.00',
  `data_entrada` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_entrada_produto_produto_idx` (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `entrada_produto`
--

INSERT INTO `entrada_produto` (`id`, `id_produto`, `qtde`, `valor_unitario`, `data_entrada`) VALUES
(1, 1, 10, '4.50', '2021-11-01'),
(2, 2, 4, '4.50', '2021-11-02');

--
-- Acionadores `entrada_produto`
--
DELIMITER $$
CREATE TRIGGER `TRG_EntradaProduto_AI` AFTER INSERT ON `entrada_produto` FOR EACH ROW BEGIN
      CALL AD_EntradaProduto (new.id_produto, new.qtde, new.valor_unitario);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE IF NOT EXISTS `estoque` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_produto` int DEFAULT NULL,
  `qtde` int DEFAULT NULL,
  `valor_unitario` decimal(9,2) DEFAULT '0.00',
  PRIMARY KEY (`id`),
  KEY `fk_estoque_produto1_idx` (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `estoque`
--

INSERT INTO `estoque` (`id`, `id_produto`, `qtde`, `valor_unitario`) VALUES
(1, 1, 10, '4.50'),
(2, 2, 4, '4.50');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  `estoque_minimo` int DEFAULT NULL,
  `estoque_maximo` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `status`, `descricao`, `estoque_minimo`, `estoque_maximo`) VALUES
(1, 'A', 'Coca-Cola', 10, 30),
(2, 'A', 'Coca-cola Zero', 10, 20),
(3, 'A', 'Fanta Uva', 5, 20);

-- --------------------------------------------------------

--
-- Estrutura da tabela `saida_produto`
--

CREATE TABLE IF NOT EXISTS `saida_produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_produto` int DEFAULT NULL,
  `qtde` int DEFAULT NULL,
  `data_saida` date DEFAULT NULL,
  `valor_unitario` decimal(9,2) DEFAULT '0.00',
  PRIMARY KEY (`id`),
  KEY `fk_saida_produto_produto1_idx` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Acionadores `saida_produto`
--
DELIMITER $$
CREATE TRIGGER `TRG_SaidaProduto_AI` BEFORE INSERT ON `saida_produto` FOR EACH ROW BEGIN
      CALL AD_SaidaProduto (new.id_produto, new.qtde, new.valor_unitario);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vw_estoqueproduto`
-- (Veja abaixo para a view atual)
--
CREATE TABLE IF NOT EXISTS `vw_estoqueproduto` (
`descricao` varchar(50)
,`estoque_maximo` int
,`estoque_minimo` int
,`id_produto` int
,`ttestoque` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Estrutura para vista `vw_estoqueproduto`
--
DROP TABLE IF EXISTS `vw_estoqueproduto`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_estoqueproduto`  AS SELECT `estoque`.`id_produto` AS `id_produto`, sum(`estoque`.`qtde`) AS `ttestoque`, `produto`.`estoque_minimo` AS `estoque_minimo`, `produto`.`estoque_maximo` AS `estoque_maximo`, `produto`.`descricao` AS `descricao` FROM (`estoque` join `produto` on((`estoque`.`id_produto` = `produto`.`id`))) GROUP BY `estoque`.`id_produto` ;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `entrada_produto`
--
ALTER TABLE `entrada_produto`
  ADD CONSTRAINT `fk_entrada_produto_produto` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`);

--
-- Limitadores para a tabela `estoque`
--
ALTER TABLE `estoque`
  ADD CONSTRAINT `fk_estoque_produto1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`);

--
-- Limitadores para a tabela `saida_produto`
--
ALTER TABLE `saida_produto`
  ADD CONSTRAINT `fk_saida_produto_produto1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
