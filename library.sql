CREATE DATABASE `library`;
USE `library`;

CREATE TABLE IF NOT EXISTS `books` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `author` varchar(64) NOT NULL,
  `copies` int(3) NOT NULL,
  `available` int(3) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE = InnoDB DEFAULT CHARSET = latin1;

INSERT INTO `books` (`title`, `author`, `copies`, `available`) VALUES ("In Search of Lost Time", "Marcel Proust", 3, 3);
INSERT INTO `books` (`title`, `author`, `copies`, `available`) VALUES ("Ulysses", "James Joyce", 7, 7);
INSERT INTO `books` (`title`, `author`, `copies`, `available`) VALUES ("Don Quixote", "Miguel de Cervantes", 10, 10);
INSERT INTO `books` (`title`, `author`, `copies`, `available`) VALUES ("The Great Gatsby", "F. Scott Fitzgerald", 12, 12);
INSERT INTO `books` (`title`, `author`, `copies`, `available`) VALUES ("One Hundred Years of Solitude", "Gabriel Garcia Marquez", 14, 14);
