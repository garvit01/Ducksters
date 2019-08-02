INSERT INTO `duckstersdb`.`userprofile` (`id`, `address`, `createdAt`, `isActive`, `isVerified`, `country`, `email`, `name`, `password`, `pincode`, `rating`, `state`) VALUES ('1', 'Delhi', 
'2091/07/24', 1, 1, 'India', 'kush@mailinator.com', 'Kush', 'Qwerty@123', '110020', '5', 'Delhi'); 
INSERT INTO `duckstersdb`.`Team` (id,`name`, isVerified,isActive) VALUES ( 1,
'Riders',true,true); 
INSERT INTO `duckstersdb`.`teamusermap` (`id`, `team_id`, `user_id`) VALUES ('1', '1', '1'); 
INSERT INTO `duckstersdb`.`Scheme` (`id`, `description`, `entryFee`, `name`, 
`organizerFee`, `transactionFee`, `winningPrize`) VALUES ('1', 'This is the  first scheme', '100', 'oneplusone', '80', '20', '1000'); 
INSERT INTO `duckstersdb`.`functions` (`id`, `createdAt`, `isActive`, `isVerified`, `name`) VALUES ('1', '2019-07-26', b'1', b'1', 'admin'); 
INSERT INTO `duckstersdb`.`Tournament` (`id`, `description`, `endDate`, `lastRegistrationDate`, `maxTeams`, `minTeams`, `name`, `place`, `startDate`, `venue`,`scheme_id`, `winner_team_id`,isVerified,status,isActive ) VALUES ('1', 'Free Tournament', '2019-07-24', '2019-07-24', '10', '6', 'CrickStart', 'New Delhi', '2019-07-24', 'New Delhi', '1', '1',true,'Live',true); 
INSERT INTO `duckstersdb`.`TournamentTeam` (`id`, `joinedDate`, 
`paymentSuccessful`, `team_id`, `tournament_id`) VALUES ('1', '2019-07-24', true, '1', '1'); 
INSERT INTO `duckstersdb`.`matches` (`id`, `place`, `scorerName`, `organizer_id`, `winner_team_id`, isVerified,isActive) VALUES ('1', 'New Delhi', 'Lalit', '1', '1',true,true); 
INSERT INTO `duckstersdb`.`MatchAward` (`id`, `award`, `award_winner_user_id`, `match_id`) VALUES ('1', 'BestBatsman', '1', '1');  
INSERT INTO `duckstersdb`.`role` (`id`, `createdAt`, `isActive`, `isVerified`, `name`, `roleType`) VALUES ('1', '2019-07-24', b'1', b'1', 'Batsman','Batsman'); 
INSERT INTO `duckstersdb`.`userrole` (`id`,`user_id`,`role_id`) VALUES ('1','1','1');
insert into userprofile values(3,'ghaziabad','2019-07-30',true,true,'201-07-22','india','hi@gmail.com','garvit','hello',110094,5,'delhi');
insert into team values(2,'2019-07-22',true,true,null,null,"secondteam");
insert into userrole values(3,1,2);
insert into userrole values(4,2,3);
 insert into teamusermap values(4,2,3);


