-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-04-2025 a las 12:32:59
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tfg4`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familia`
--

CREATE TABLE `familia` (
  `id_familia` int(11) NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `dni_admin` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificaciones`
--

CREATE TABLE `notificaciones` (
  `id_mensaje` int(11) NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `cuerpo` text DEFAULT NULL,
  `destinatario` varchar(9) DEFAULT NULL,
  `dni_admin` varchar(9) DEFAULT NULL,
  `fecha_hora` datetime DEFAULT current_timestamp(),
  `leido` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `premios`
--

CREATE TABLE `premios` (
  `id_premio` varchar(40) NOT NULL,
  `puntos_requeridos` int(10) DEFAULT NULL,
  `id_familia` int(10) DEFAULT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT 1,
  `duracion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas`
--

CREATE TABLE `tareas` (
  `id_tarea` varchar(40) NOT NULL,
  `puntos` int(10) DEFAULT NULL,
  `id_familia` int(10) DEFAULT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_hace_tareas`
--

CREATE TABLE `usuario_hace_tareas` (
  `dni` varchar(9) NOT NULL,
  `id_tarea` varchar(40) NOT NULL,
  `fecha_realizada` datetime NOT NULL,
  `check_tarea` tinyint(1) DEFAULT 0,
  `comentarios` varchar(100) DEFAULT NULL,
  `puntos_obtenidos` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_pertenece_familia`
--

CREATE TABLE `usuario_pertenece_familia` (
  `dni` varchar(9) NOT NULL,
  `id_familia` int(10) NOT NULL,
  `puntos` int(8) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_reclama_premios`
--

CREATE TABLE `usuario_reclama_premios` (
  `dni` varchar(9) NOT NULL,
  `id_premio` varchar(40) NOT NULL,
  `reclamado` datetime NOT NULL,
  `activo` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `familia`
--
ALTER TABLE `familia`
  ADD PRIMARY KEY (`id_familia`),
  ADD KEY `dni_admin` (`dni_admin`);

--
-- Indices de la tabla `notificaciones`
--
ALTER TABLE `notificaciones`
  ADD PRIMARY KEY (`id_mensaje`),
  ADD KEY `dni_admin` (`dni_admin`);

--
-- Indices de la tabla `premios`
--
ALTER TABLE `premios`
  ADD PRIMARY KEY (`id_premio`),
  ADD KEY `id_familia` (`id_familia`);

--
-- Indices de la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD PRIMARY KEY (`id_tarea`),
  ADD KEY `id_familia` (`id_familia`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `usuario_hace_tareas`
--
ALTER TABLE `usuario_hace_tareas`
  ADD PRIMARY KEY (`dni`,`id_tarea`,`fecha_realizada`),
  ADD KEY `id_tarea` (`id_tarea`);

--
-- Indices de la tabla `usuario_pertenece_familia`
--
ALTER TABLE `usuario_pertenece_familia`
  ADD PRIMARY KEY (`dni`,`id_familia`),
  ADD KEY `id_familia` (`id_familia`);

--
-- Indices de la tabla `usuario_reclama_premios`
--
ALTER TABLE `usuario_reclama_premios`
  ADD PRIMARY KEY (`dni`,`id_premio`,`reclamado`),
  ADD KEY `id_premio` (`id_premio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `familia`
--
ALTER TABLE `familia`
  MODIFY `id_familia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `notificaciones`
--
ALTER TABLE `notificaciones`
  MODIFY `id_mensaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `familia`
--
ALTER TABLE `familia`
  ADD CONSTRAINT `familia_ibfk_1` FOREIGN KEY (`dni_admin`) REFERENCES `usuario` (`dni`);

--
-- Filtros para la tabla `notificaciones`
--
ALTER TABLE `notificaciones`
  ADD CONSTRAINT `fk_notificaciones_familia` FOREIGN KEY (`dni_admin`) REFERENCES `familia` (`dni_admin`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `premios`
--
ALTER TABLE `premios`
  ADD CONSTRAINT `premios_ibfk_1` FOREIGN KEY (`id_familia`) REFERENCES `familia` (`id_familia`);

--
-- Filtros para la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD CONSTRAINT `tareas_ibfk_1` FOREIGN KEY (`id_familia`) REFERENCES `familia` (`id_familia`);

--
-- Filtros para la tabla `usuario_hace_tareas`
--
ALTER TABLE `usuario_hace_tareas`
  ADD CONSTRAINT `usuario_hace_tareas_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `usuario` (`dni`),
  ADD CONSTRAINT `usuario_hace_tareas_ibfk_2` FOREIGN KEY (`id_tarea`) REFERENCES `tareas` (`id_tarea`);

--
-- Filtros para la tabla `usuario_pertenece_familia`
--
ALTER TABLE `usuario_pertenece_familia`
  ADD CONSTRAINT `usuario_pertenece_familia_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `usuario` (`dni`),
  ADD CONSTRAINT `usuario_pertenece_familia_ibfk_2` FOREIGN KEY (`id_familia`) REFERENCES `familia` (`id_familia`);

--
-- Filtros para la tabla `usuario_reclama_premios`
--
ALTER TABLE `usuario_reclama_premios`
  ADD CONSTRAINT `usuario_reclama_premios_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `usuario` (`dni`),
  ADD CONSTRAINT `usuario_reclama_premios_ibfk_2` FOREIGN KEY (`id_premio`) REFERENCES `premios` (`id_premio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
