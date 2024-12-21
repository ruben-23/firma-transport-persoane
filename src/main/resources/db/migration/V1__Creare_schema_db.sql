

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema transport_persoane
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema transport_persoane
-- -----------------------------------------------------

USE `transport_persoane` ;

-- -----------------------------------------------------
-- Table `transport_persoane`.`localitati`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transport_persoane`.`localitati` (
                                                                 `id_localitate` INT NOT NULL AUTO_INCREMENT,
                                                                 `nume` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id_localitate`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transport_persoane`.`rute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transport_persoane`.`rute` (
                                                           `id_ruta` INT NOT NULL AUTO_INCREMENT,
                                                           `id_localitate_inceput` INT NOT NULL,
                                                           `id_localitate_destinatie` INT NOT NULL,
                                                           PRIMARY KEY (`id_ruta`),
    INDEX `fk_rute_localitati1_idx` (`id_localitate_inceput` ASC) VISIBLE,
    INDEX `fk_rute_localitati2_idx` (`id_localitate_destinatie` ASC) VISIBLE,
    CONSTRAINT `fk_rute_localitati1`
    FOREIGN KEY (`id_localitate_inceput`)
    REFERENCES `transport_persoane`.`localitati` (`id_localitate`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    CONSTRAINT `fk_rute_localitati2`
    FOREIGN KEY (`id_localitate_destinatie`)
    REFERENCES `transport_persoane`.`localitati` (`id_localitate`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transport_persoane`.`preturi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transport_persoane`.`preturi` (
                                                              `id_pret` INT NOT NULL AUTO_INCREMENT,
                                                              `pret` INT NOT NULL,
                                                              `id_localitate` INT NOT NULL,
                                                              `id_ruta` INT NOT NULL,
                                                              PRIMARY KEY (`id_pret`),
    INDEX `fk_preturi_localitati1_idx` (`id_localitate` ASC) VISIBLE,
    INDEX `fk_preturi_rute1_idx` (`id_ruta` ASC) VISIBLE,
    CONSTRAINT `fk_preturi_localitati1`
    FOREIGN KEY (`id_localitate`)
    REFERENCES `transport_persoane`.`localitati` (`id_localitate`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    CONSTRAINT `fk_preturi_rute1`
    FOREIGN KEY (`id_ruta`)
    REFERENCES `transport_persoane`.`rute` (`id_ruta`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transport_persoane`.`orare`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transport_persoane`.`orare` (
                                                            `id_orar` INT NOT NULL AUTO_INCREMENT,
                                                            `ora_plecare` TIME NOT NULL,
                                                            `zi` VARCHAR(45) NOT NULL,
    `id_localitate_plecare` INT NOT NULL,
    `id_ruta` INT NOT NULL,
    PRIMARY KEY (`id_orar`),
    INDEX `fk_orare_localitati1_idx` (`id_localitate_plecare` ASC) VISIBLE,
    INDEX `fk_orare_rute1_idx` (`id_ruta` ASC) VISIBLE,
    CONSTRAINT `fk_orare_localitati1`
    FOREIGN KEY (`id_localitate_plecare`)
    REFERENCES `transport_persoane`.`localitati` (`id_localitate`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    CONSTRAINT `fk_orare_rute1`
    FOREIGN KEY (`id_ruta`)
    REFERENCES `transport_persoane`.`rute` (`id_ruta`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transport_persoane`.`bilete`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transport_persoane`.`bilete` (
                                                             `id_bilet` INT NOT NULL AUTO_INCREMENT,
                                                             `timp_cumparare` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                             `id_pret` INT NOT NULL,
                                                             `id_orar` INT NOT NULL,
                                                             PRIMARY KEY (`id_bilet`),
    INDEX `fk_bilete_preturi_idx` (`id_pret` ASC) VISIBLE,
    INDEX `fk_bilete_orare1_idx` (`id_orar` ASC) VISIBLE,
    CONSTRAINT `fk_bilete_preturi`
    FOREIGN KEY (`id_pret`)
    REFERENCES `transport_persoane`.`preturi` (`id_pret`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    CONSTRAINT `fk_bilete_orare1`
    FOREIGN KEY (`id_orar`)
    REFERENCES `transport_persoane`.`orare` (`id_orar`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transport_persoane`.`firma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transport_persoane`.`firma` (
                                                            `id_firma` INT NOT NULL AUTO_INCREMENT,
                                                            `nume` VARCHAR(100) NOT NULL,
    `adresa` VARCHAR(255) NOT NULL,
    `numar_telefon` VARCHAR(45) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id_firma`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transport_persoane`.`autobuze`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transport_persoane`.`autobuze` (
                                                               `id_autobuz` INT NOT NULL AUTO_INCREMENT,
                                                               `numar_inmatriculare` VARCHAR(50) NOT NULL,
    `status` VARCHAR(50) NULL,
    `capacitate` INT NOT NULL,
    `id_ruta` INT NULL,
    `id_firma` INT NOT NULL,
    PRIMARY KEY (`id_autobuz`),
    INDEX `fk_autobuze_rute1_idx` (`id_ruta` ASC) VISIBLE,
    INDEX `fk_autobuze_firma1_idx` (`id_firma` ASC) VISIBLE,
    CONSTRAINT `fk_autobuze_rute1`
    FOREIGN KEY (`id_ruta`)
    REFERENCES `transport_persoane`.`rute` (`id_ruta`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    CONSTRAINT `fk_autobuze_firma1`
    FOREIGN KEY (`id_firma`)
    REFERENCES `transport_persoane`.`firma` (`id_firma`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transport_persoane`.`localitati_intermediare`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transport_persoane`.`localitati_intermediare` (
                                                                              `id_ruta` INT NOT NULL,
                                                                              `id_localitate` INT NOT NULL,
                                                                              `ordine` INT NULL,
                                                                              INDEX `fk_rute_localitati_rute1_idx` (`id_ruta` ASC) VISIBLE,
    INDEX `fk_rute_localitati_localitati1_idx` (`id_localitate` ASC) VISIBLE,
    PRIMARY KEY (`id_ruta`, `id_localitate`),
    CONSTRAINT `fk_rute_localitati_rute1`
    FOREIGN KEY (`id_ruta`)
    REFERENCES `transport_persoane`.`rute` (`id_ruta`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    CONSTRAINT `fk_rute_localitati_localitati1`
    FOREIGN KEY (`id_localitate`)
    REFERENCES `transport_persoane`.`localitati` (`id_localitate`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transport_persoane`.`feedbackuri`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transport_persoane`.`feedbackuri` (
                                                                  `id_feedback` INT NOT NULL AUTO_INCREMENT,
                                                                  `tip` VARCHAR(50) NOT NULL,
    `timp_trimitere` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `mesaj` TEXT NOT NULL,
    `id_firma` INT NOT NULL,
    PRIMARY KEY (`id_feedback`),
    INDEX `fk_feedbackuri_firma1_idx` (`id_firma` ASC) VISIBLE,
    CONSTRAINT `fk_feedbackuri_firma1`
    FOREIGN KEY (`id_firma`)
    REFERENCES `transport_persoane`.`firma` (`id_firma`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
