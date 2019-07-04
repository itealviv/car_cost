  # itea.task
  Це завдання розраховує  вартість авто з врахуванням року, країни, об'єма двигуна та зберігає результати в базі даних
  Користувач обирає авто, рік випуску, країну та об'єем двигуна
  #### SQL create code
  Таблиця результатів
  
    CREATE TABLE `cars` (
        `id` INT(11) NOT NULL AUTO_INCREMENT,
        `car_id` INT(11) NOT NULL DEFAULT '0',
        `name` VARCHAR(50) NULL DEFAULT NULL,
        `country` INT(11) NULL DEFAULT NULL,
        `price` DECIMAL(10,2) NULL DEFAULT NULL,
        `engine` INT(11) NOT NULL DEFAULT '1',
        `year` INT(11) NOT NULL,
        `carPrice` DOUBLE NOT NULL,
        PRIMARY KEY (`id`),
        INDEX `FK_cars_country` (`country`),
        INDEX `FK_cars_engines` (`engine`),
        INDEX `FK_cars_years` (`year`),
        INDEX `FK_cars_cars` (`car_id`),
        CONSTRAINT `FK_cars_cars` FOREIGN KEY (`car_id`) REFERENCES `newCar` (`id`),
        CONSTRAINT `FK_cars_country` FOREIGN KEY (`country`) REFERENCES `country` (`id`),
        CONSTRAINT `FK_cars_engines` FOREIGN KEY (`engine`) REFERENCES `engines` (`id`),
        CONSTRAINT `FK_cars_years` FOREIGN KEY (`year`) REFERENCES `years` (`id`)
      )
      COLLATE='utf8_general_ci'
      ENGINE=InnoDB
      AUTO_INCREMENT=0;
  
  
  Таблиці з даними
  
      -- Dumping structure for таблиця java.country
      CREATE TABLE IF NOT EXISTS `country` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(50) NOT NULL DEFAULT '0',
        `vat` double NOT NULL DEFAULT 1.1,
        PRIMARY KEY (`id`)
      ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
      
      -- Dumping data for table java.country: ~4 rows (приблизно)
      /*!40000 ALTER TABLE `country` DISABLE KEYS */;
      INSERT INTO `country` (`id`, `name`, `vat`) VALUES
        (1, 'Poland', 1.1),
        (2, 'Chech', 1.2),
        (3, 'Belarus', 1.3),
        (4, 'Germany', 1.4);
      /*!40000 ALTER TABLE `country` ENABLE KEYS */;
      
      -- Dumping structure for таблиця java.engines
      CREATE TABLE IF NOT EXISTS `engines` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `engine` double NOT NULL DEFAULT 1.4,
        PRIMARY KEY (`id`)
      ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
      
      -- Dumping data for table java.engines: ~6 rows (приблизно)
      /*!40000 ALTER TABLE `engines` DISABLE KEYS */;
      INSERT INTO `engines` (`id`, `engine`) VALUES
        (1, 1.2),
        (2, 1.4),
        (3, 1.6),
        (4, 1.8),
        (5, 1.9),
        (6, 2.4);
      /*!40000 ALTER TABLE `engines` ENABLE KEYS */;
      
      -- Dumping structure for таблиця java.newCar
      CREATE TABLE IF NOT EXISTS `newCar` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(50) NOT NULL DEFAULT '0',
        `price` double NOT NULL DEFAULT 0,
        PRIMARY KEY (`id`)
      ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
      
      -- Dumping data for table java.newCar: ~6 rows (приблизно)
      /*!40000 ALTER TABLE `newCar` DISABLE KEYS */;
      INSERT INTO `newCar` (`id`, `name`, `price`) VALUES
        (1, 'Volvo', 8500.2),
        (2, 'VolksWagen', 11670),
        (3, 'Ford', 15000),
        (4, 'Lada', 2540.5),
        (5, 'Hyndai', 11300),
        (6, 'Brabus', 120000);
      /*!40000 ALTER TABLE `newCar` ENABLE KEYS */;
      
      -- Dumping structure for таблиця java.years
      CREATE TABLE IF NOT EXISTS `years` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `year` char(4) NOT NULL DEFAULT '1979',
        `vat` double NOT NULL,
        PRIMARY KEY (`id`)
      ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
      
      -- Dumping data for table java.years: ~6 rows (приблизно)
      /*!40000 ALTER TABLE `years` DISABLE KEYS */;
      INSERT INTO `years` (`id`, `year`, `vat`) VALUES
        (1, '1979', 3.5),
        (2, '2000', 3.2),
        (3, '2010', 2.8),
        (4, '2011', 2.5),
        (5, '2016', 2),
        (6, '2019', 1.5);
      /*!40000 ALTER TABLE `years` ENABLE KEYS */;
  
    
   Обов'язково додати драйвер до вашої версії бази даних
   
   Запуск з файла main папка main
