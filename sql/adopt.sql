-- MySQL dump 10.13  Distrib 5.6.40, for Win64 (x86_64)
--
-- Host: localhost    Database: adopt
-- ------------------------------------------------------
-- Server version	5.6.40

DROP DATABASE IF EXISTS adopt;
CREATE DATABASE adopt;
USE adopt;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) NOT NULL COMMENT '管理员的名字',
  `adminPwd` varchar(20) NOT NULL COMMENT '密码',
  `realName` varchar(20) NOT NULL COMMENT '真实的名字',
  `telephone` varchar(20) NOT NULL COMMENT '电话',
  `Email` varchar(20) NOT NULL,
  `birthday` date NOT NULL,
  `sex` varchar(3) NOT NULL,
  `pic` varchar(100) DEFAULT 'a.png',
  `remark` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES (1,'齐达内','yi123','杨一','13902193927','2425902914@qq.com','1993-09-10','男','a1.png','外号 玄宗。这位可是我们团队的玄学的代表。由他在似乎任何困难都能解决。'),(2,'卡瓦哈尔','wemz123','王二麻子','14402193927','2425902016@qq.com','1994-09-12','男','a2.png','外号 大傻；他是我们团队中最热心的人。他积极参加团队活动，并且在团队需要他的时候总是全力完成 '),(3,'瓦拉内','zs123','张三','14495893927','2917902016@qq.com','1994-10-12','男','a3.png','外号 学霸。这是为真正的学霸，他平时热心团队活动，并且负责团队的财务管理，认真严谨。'),(4,'拉莫斯','ls123','李四','14495893012','2107902016@qq.com','1994-06-09','男','a4.png','外号 水爷。这位团队外号虽然有水，但是一点也不水，他是我们的队长，为了团队他付出了最多的精力，而且他经常保护队员的安全.'),(5,'纳乔','ww123','王五','14495890112','2992902016@qq.com','1995-06-12','女','a5.png','外号 万金油。这位队员人如其名，是我们团队的万金油，当我们团队成员，紧急有事的时候，他都能顶上去，是一个很可靠的人。'),(6,'马塞洛','zl123','赵六','13195890112','2992909126@qq.com','1995-09-12','男','a6.png','外号 队宠。这位是我们的副队长，他是我们团队的开心果，在平常的活动中，他总能带给我们快乐。'),(7,'阿扎尔','sql1234','孙七','13195890081','2992909823@qq.com','1995-10-12','男','a7.png','外号 杨坤。这位不仅是团队中的颜值代表，而且是技术代表，他对小动物的保护知识是专家。他总能在保护小动物的方面给出正确的建议。'),(9,'本泽马','342','342','342','342','2019-08-20','女','a9.png','外号 背锅侠。这位是我们团队中的冲锋者，勇敢。但由于一些事，就造就了背锅侠的名号。'),(10,'莫德里奇','111','卢卡','15797959509','2425549281@qq.com','2019-08-05','男','a10.png','外号 魔笛。这位和我们团队中的杨坤都是技术与颜值的代表，而且他总是保持一颗冷静的心，在面对困难的时候，总是临危不惧。'),(11,'贝尔','1111','孙悟空','15797959509','2425549281@qq.com','1990-01-30','女','a11.png','号称孙悟空，无敌的存在！！');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `replayId` int(11) DEFAULT NULL,
  `commentId` int(11) NOT NULL,
  `answerTime` date NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk8` (`userId`),
  KEY `fk11` (`commentId`),
  KEY `fk10` (`replayId`),
  CONSTRAINT `fk10` FOREIGN KEY (`replayId`) REFERENCES `answer` (`id`),
  CONSTRAINT `fk11` FOREIGN KEY (`commentId`) REFERENCES `comment` (`id`),
  CONSTRAINT `fk8` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,2,NULL,8,'2018-08-23','这条狗很好动。 '),(2,5,1,8,'2018-08-23','这只宠物很乖。'),(3,3,2,8,'2019-09-06','我也喜欢这样的宠物。'),(5,1,NULL,8,'2019-09-07','我也喜欢这样的宠物。'),(6,1,NULL,8,'2019-09-07','我也喜欢这样的宠物。'),(7,1,NULL,11,'2019-09-07','我也喜欢这样的宠物。'),(8,17,NULL,8,'2019-09-08','我也喜欢这样的宠物。'),(9,17,NULL,8,'2019-09-08','我也喜欢这样的宠物。'),(10,17,NULL,12,'2019-09-09','我也喜欢这样的宠物。'),(11,17,NULL,11,'2019-09-09','我也喜欢这样的宠物。');
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apply`
--

DROP TABLE IF EXISTS `apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `email` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `message` varchar(100) NOT NULL,
  `applyTime` date NOT NULL,
  `state` int(11) DEFAULT '2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply`
--

LOCK TABLES `apply` WRITE;
/*!40000 ALTER TABLE `apply` DISABLE KEYS */;
INSERT INTO `apply` VALUES (1,'Wu Xin','2425549281@qq.com',24,'15797959509','想打球','2019-08-29',3),(2,'张三丰','2425549281@qq.com',21,'15797959509','当打球！！！！！','2019-09-04',3),(3,'4334','4343',4334,'4343','434343','2019-09-05',2),(4,'公孙策','2425549281@qq.com',45,'15797959509','我想保护流浪动物。','2019-09-05',2);
/*!40000 ALTER TABLE `apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actionTime` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `peoples` varchar(100) NOT NULL,
  `event` varchar(100) NOT NULL,
  `title` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (1,'2019-08-11','江西省南昌市','张三，李四，王五.','自愿去春风小区对小区的动物进行检查和医疗','保护小动物'),(2,'2019-04-12','江西省南昌市','张三,王五','自愿去春风小区对小区的动物进行检查和医疗','保护小动物'),(3,'2010-02-09','江西省南昌市','王二麻子,李四','去收养路边的猫狗1','保护小动物'),(4,'2012-03-10','江西省南昌市','王二麻子,张三,李四','去收养路边的猫','保护小动物'),(5,'2014-03-10','江西省南昌市','张三,李四','去治疗路边的猫','保护小动物'),(6,'2014-05-10','江西省南昌市','张三,李四，王五','去治疗路边的猫狗','保护小动物'),(7,'2017-01-10','江西省南昌市','王五','去喂养流浪的猫狗','保护小动物'),(8,'2018-01-10','江西省西昌市','杨一','去喂养流浪的猫狗','保护小动物'),(9,'2018-11-10','江西省余干县','杨一,王二麻子','去喂养流浪的猫狗','保护小动物'),(10,'2019-01-10','江西省上饶市余干县','杨一,王二麻子','去喂养流浪的猫狗','保护小动物'),(11,'2019-08-29','金利源大酒店','团队全体成员','为水爷和学霸庆生。','团队生日'),(14,'2019-09-05','45','54','54','65');
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `adminsId` int(11) DEFAULT NULL,
  `petId` int(11) DEFAULT NULL,
  `commentTime` date NOT NULL,
  `content` varchar(200) NOT NULL COMMENT '评论的内容',
  PRIMARY KEY (`id`),
  KEY `fk1` (`userId`),
  KEY `fk2` (`petId`),
  KEY `fk5` (`adminsId`),
  CONSTRAINT `fk1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`petId`) REFERENCES `pet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk5` FOREIGN KEY (`adminsId`) REFERENCES `admins` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1,NULL,1,'2019-08-16','这条猫不错！'),(3,3,NULL,1,'2019-08-21','这只猫善解人意'),(4,4,NULL,2,'2019-08-21','这条猫不错'),(5,5,NULL,2,'2019-08-22','这条猫不错'),(6,6,NULL,3,'2019-08-22','这条猫不错'),(7,7,NULL,4,'2019-08-22','这条猫不错'),(8,8,NULL,5,'2019-08-22','这条狗不错'),(9,9,NULL,6,'2019-08-22','这条狗不错'),(10,NULL,1,9,'2019-08-23','这条猫不错'),(11,1,NULL,5,'2019-08-30','这条狗很活泼。'),(12,1,NULL,5,'2019-08-30','这条狗很活泼，喜欢在户外玩耍。');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `petName` varchar(20) NOT NULL,
  `petType` varchar(20) NOT NULL COMMENT '宠物类型',
  `sex` varchar(3) NOT NULL COMMENT '性别',
  `birthday` date NOT NULL,
  `pic` varchar(100) NOT NULL COMMENT '头像',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '现在的状态 0 没有申请领养 1 被申请领养 2 已经被领养',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
INSERT INTO `pet` VALUES (1,'kitty','波斯猫','雄性','2018-09-10','cat1_1.jpg,cat1_2.jpg,cat1_3.jpg',1,'kitty是一名害羞，温暖，柔和，友善的波斯猫。'),(2,'Vito','波斯猫','雄性','2018-09-21','cat2_1.jpg,cat2_2.jpg,cat2_3.jpg',0,'Vito是一只精力充沛的猫，比起其他猫更加热爱玩耍。'),(3,'kena','短尾猫','雌性','2018-01-21','cat3_1.jpg,cat3_2.jpg,cat3_3.jpg,cat3_4.jpg',1,'Kena是一只可爱活泼的小公主，对食物有份执着，她向往自由，喜欢无拘无束的生活。'),(4,'Vamp','波斯猫','雌性','2018-11-21','cat4_1.jpg,cat4_2.jpg,cat4_3.jpg,cat4_4.jpg',1,'Vamp是一只雄性蓝色的波斯猫。他安静，不喜欢玩耍。'),(5,'辛巴','牧羊犬','雄性','2018-11-21','dog1_1.jpg,dog1_2.jpg,dog1_3.jpg,dog1_4.jpg',0,'辛巴活泼又好奇，特别喜欢和别的狗狗玩耍，更十分喜欢户外活动。一个没有儿童的家庭更适合他，你愿意成为辛巴的好朋友，让他继续快乐的成长吗？'),(6,'glery','藏獒','雄性','2019-01-21','dog2_1.jpg,dog2_2.jpg,dog2_3.jpg,dog2_4.jpg',1,'kito是一只好奇，活力，智能，热情奔放的藏獒。'),(7,'Soju','藏獒','雄性','2019-01-21','dog3_1.jpg,dog3_2.jpg,dog3_3.jpg',1,'Soju是一只好奇，活力，智能，热情奔放的藏獒。'),(8,'Minnie','橘猫','雌性','2018-11-21','cat5_1.jpg,cat5_2.jpg,cat5_3.jpg,cat5_4.jpg',1,'MInnie是一名害羞，胆小，巨能吃的橘猫。'),(9,'Kena','狸猫','雌性','2018-11-21','cat6_1.jpg,cat6_2.jpg,cat6_3.jpg,cat6_4.jpg',2,'Kena是一名害羞，温暖，柔和，友善的狸猫。'),(10,'Pigge','牧羊犬','雌性','2018-03-19','dog4_1.jpg,dog4_2.jpg,dog4_3.jpg',1,'Pigge是一只喜欢玩耍的牧羊犬，但他在主人需要的时候，总是尽职尽责。'),(11,'Tommy','秋田犬','雄性','2019-07-12','dog5_1.jpg,dog5_2.jpg,dog5_3.jpg',0,'Tommy是一只喜欢玩耍的牧羊犬，但他在主人需要的时候，总是尽职尽责。'),(12,'James','短尾猫','雄性','2019-05-12','cat7_1.jpg,cat7_2.jpg,cat7_3.jpg',0,'James是一只精力充沛的猫，比起其他猫更加热爱玩耍。'),(13,'Snow','雪橇犬','雄性','2019-06-12','dog6_1.jpg,dog6_2.jpg,dog6_3.jpg',0,'Snow外表是一个很安静的犬，但是动起来比什么狗都爱玩耍。'),(14,'Isio','牧羊犬','雌性','2019-06-29','dog7_1.jpg,dog7_2.jpg,dog7_3.jpg',0,''),(16,'水母','秋田犬','雄性','2019-08-31','dog8_1.jpg,dog8_2.jpg,dog8_3.jpg',0,'ewew');
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adoptAnimal`
--

DROP TABLE IF EXISTS `adoptAnimal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adoptAnimal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户表id的外键',
  `petId` int(11) NOT NULL COMMENT '宠物表id的外键',
  `adoptTime` date NOT NULL,
  `state` int(11) DEFAULT '1' COMMENT '是否同意被领养 0 是不同意 1 还在审核 2 是同意',
  PRIMARY KEY (`id`),
  KEY `fk3` (`userId`),
  KEY `fk4` (`petId`),
  CONSTRAINT `fk3` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk4` FOREIGN KEY (`petId`) REFERENCES `pet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adoptAnimal`
--

LOCK TABLES `adoptAnimal` WRITE;
/*!40000 ALTER TABLE `adoptAnimal` DISABLE KEYS */;
INSERT INTO `adoptAnimal` VALUES (1,1,1,'2019-08-21',2),(2,5,2,'2019-08-20',0),(3,3,3,'2019-08-19',1),(4,4,4,'2019-08-18',0),(5,2,5,'2019-08-17',0),(6,6,6,'2019-08-16',1),(7,7,7,'2019-08-15',1),(8,2,8,'2019-08-14',0),(9,9,9,'2019-08-13',2),(10,9,1,'2019-08-09',0),(13,1,5,'2019-09-01',0),(14,30,5,'2019-09-09',0),(15,30,2,'2019-09-09',0),(16,30,2,'2019-09-09',0),(17,30,10,'2019-09-09',1);
/*!40000 ALTER TABLE `adoptAnimal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `Time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES ('2019-08-23');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话',
  `Email` varchar(30) DEFAULT NULL COMMENT 'Email',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `pic` varchar(100) DEFAULT 't0.jpg',
  `state` int(11) DEFAULT '0' COMMENT '有无领养宠物的经历 0 是没有 1 是由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'张三丰','zsf123','男',100,'13809182091','2425549281@qq.com','湖北武当山','t1.jpg',1),(2,'宋远桥','syq123','男',50,'13908457344','2425549281@qq.com','湖北武当山','t2.jpg',0),(3,'俞莲舟','ylz123','男',45,'13903827601','2425549281@qq.com','湖北武当山','t3.jpg',1),(4,'俞岱岩','ydy123','男',43,'13903822001','2425549281@qq.com','湖北武当山','t4.jpg',1),(5,'赵敏','zm123','女',23,'13903810621','2425549281@qq.com','蒙古科尔沁','t5.jpg',1),(6,'张松溪','zsx123','男',40,'13903819146','2425549281@qq.com','湖北武当山','t6.jpg',0),(7,'张翠山','zcs123','男',38,'13903819301','2425549281@qq.com','湖北武当山','t7.jpg',0),(8,'殷素素','yss123','女',35,'13123819301','2425549281@qq.com','光明顶','t8.jpg',0),(9,'殷梨亭','ylt123','男',35,'13123249301','2425549281@qq.com','湖北武当山','t9.jpg',1),(10,'莫声谷','msg123','男',32,'13123249892','2425549281@qq.com','湖北武当山','t10.jpg',1),(11,'张无忌','zwj123','男',21,'15797959509','2425549281@qq.com','光明顶','t11.jpg',1),(12,'杨逍','123','男',45,'15797959509','2425549281@qq.com','光明顶','t12.jpg',0),(13,'白眉鹰王','8888','男',75,'15797959509','2425549281@qq.com','光明顶','t13.jpg',0),(14,'觉远大师','8888','男',145,'15797959509','2425549281@qq.com','嵩山少林寺','t14.jpg',1),(15,'包拯','1111','男',19,'15797959509','2425549281@qq.com','开封','t15.jpg',0),(16,'展昭','2222','男',31,'15797959509','2425549281@qq.com','开封','t16.jpg',0),(17,'小龙女','4444','女',32,'15797959509','2425549281@qq.com','古墓','t17.jpg',0),(18,'王语嫣','7777','女',45,'15797959509','2425549281@qq.com','云南大理','t18.jpg',0),(19,'段誉','1111','男',26,'15797959509','2425549281@qq.com','江西省南昌市','t19.jpg',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-09 22:31:39
