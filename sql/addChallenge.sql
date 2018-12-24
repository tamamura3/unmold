set names utf8;
set foreign_key_checks = 0;
USE overflowing;

update challenge set
description = "We are born in society. It's natural to communicate with people.\r\nStart a conversation with random completely strangers."
where challenge_name = "Have A Conversation With Strangers";

update challenge set
challenge_name = "Try Foods You Have Never Eaten"
where description = "At grocery store, pick ingredients you had never eaten.At restaurant, order something you had never tried.";