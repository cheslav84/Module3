-- -----------------------------------------------------
-- `SUBJECT`
-- -----------------------------------------------------
INSERT INTO subject (id, name) VALUES ('8a0fce0f-f714-4035-9e94-5018ec98ba9c', 'Java');
INSERT INTO subject (id, name) VALUES ('4e77635c-b3ae-478a-b0e8-5dfd929a7f01', 'Testing');
INSERT INTO subject (id, name) VALUES ('efb2f5de-c3e2-4056-a949-e84db49f7ba0', 'Web Design');

-- -----------------------------------------------------
-- `CLASS`
-- -----------------------------------------------------
INSERT INTO class (id, name) VALUES ('e6923c19-b0f9-4e2b-a3a7-e67e305e0ffa', 'A-Level');
INSERT INTO class (id, name) VALUES ('29b5d1af-fe6e-499f-a039-914295c63fe4', 'B-Level');
INSERT INTO class (id, name) VALUES ('0ea0a09f-98d2-4491-8608-a68cb8001974', 'A-Degree');

-- -----------------------------------------------------
-- `PERSON`
-- -----------------------------------------------------
INSERT INTO person (id, age, name, surname) VALUES ('921b27f1-109d-44fd-b2ca-1d1248b8b51e', '55', 'Брюс', 'Вілліс');
INSERT INTO person (id, age, name, surname) VALUES ('6f854187-e21d-491f-b9ca-564f6795a90f', '64', 'Чак', 'Норіс');
INSERT INTO person (id, age, name, surname) VALUES ('39838fb6-0dd8-40e2-b0fd-9481cd9e6ea7', '25', 'Анджеліна', 'Джолі');

INSERT INTO person (id, age, name, surname) VALUES ('a3540720-d99c-4088-a4f1-6898d8e35695', '38', 'Джеккі', 'Чан');
INSERT INTO person (id, age, name, surname) VALUES ('647d4460-69bb-4697-8fa8-51faf26dbd3e', '40', 'Джейсон', 'Стейтем');
INSERT INTO person (id, age, name, surname) VALUES ('bb0f6fbc-60d2-42c7-91b9-f991355b8758', '18', 'Мілла', 'Йовович');
INSERT INTO person (id, age, name, surname) VALUES ('a3c26711-2cf7-40bc-8fef-99da0f0c022a', '22', 'Джулія', 'Робертс');
INSERT INTO person (id, age, name, surname) VALUES ('9c5d2eba-5c40-4361-8022-409055310fb4', '27', 'Він', 'Дизель');
INSERT INTO person (id, age, name, surname) VALUES ('3bfec498-91a3-4162-b52d-fb8567dc3553', '25', 'Піт', 'Бред');
INSERT INTO person (id, age, name, surname) VALUES ('24a4e305-14ae-4720-a348-59f0f05a6401', '24', 'Лотнер', 'Тейлор');
INSERT INTO person (id, age, name, surname) VALUES ('20a31e0d-b395-4b99-ab40-a385f4cce7b1', '50', 'Траволта', 'Джон');
INSERT INTO person (id, age, name, surname) VALUES ('98ae0a8f-486e-4957-8f61-412116e9fbb6', '37', 'Двейн', 'Джонсон');
INSERT INTO person (id, age, name, surname) VALUES ('4525deff-02a2-4ed2-8498-d920e78b1163', '50', 'Расселл', 'Кроу');
INSERT INTO person (id, age, name, surname) VALUES ('31d4d3f7-4bc4-470c-a62f-c8775db609a4', '35', 'Кідман', 'Ніколь');

-- -----------------------------------------------------
-- `MENTOR`
-- -----------------------------------------------------
INSERT INTO mentor (id, subject_id) VALUES ('921b27f1-109d-44fd-b2ca-1d1248b8b51e', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');
INSERT INTO mentor (id, subject_id) VALUES ('6f854187-e21d-491f-b9ca-564f6795a90f', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');
INSERT INTO mentor (id, subject_id) VALUES ('39838fb6-0dd8-40e2-b0fd-9481cd9e6ea7', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');

-- -----------------------------------------------------
-- `STUDENT`
-- -----------------------------------------------------
INSERT INTO student (id, entry_date, class_id) VALUES ('a3540720-d99c-4088-a4f1-6898d8e35695', '2022-10-16', 'e6923c19-b0f9-4e2b-a3a7-e67e305e0ffa');
INSERT INTO student (id, entry_date, class_id) VALUES ('647d4460-69bb-4697-8fa8-51faf26dbd3e', '2022-10-16', 'e6923c19-b0f9-4e2b-a3a7-e67e305e0ffa');
INSERT INTO student (id, entry_date, class_id) VALUES ('bb0f6fbc-60d2-42c7-91b9-f991355b8758', '2022-10-16', 'e6923c19-b0f9-4e2b-a3a7-e67e305e0ffa');
INSERT INTO student (id, entry_date, class_id) VALUES ('a3c26711-2cf7-40bc-8fef-99da0f0c022a', '2022-09-16', 'e6923c19-b0f9-4e2b-a3a7-e67e305e0ffa');
INSERT INTO student (id, entry_date, class_id) VALUES ('9c5d2eba-5c40-4361-8022-409055310fb4', '2021-09-17', '29b5d1af-fe6e-499f-a039-914295c63fe4');
INSERT INTO student (id, entry_date, class_id) VALUES ('3bfec498-91a3-4162-b52d-fb8567dc3553', '2021-09-17', '29b5d1af-fe6e-499f-a039-914295c63fe4');
INSERT INTO student (id, entry_date, class_id) VALUES ('24a4e305-14ae-4720-a348-59f0f05a6401', '2021-09-17', '29b5d1af-fe6e-499f-a039-914295c63fe4');
INSERT INTO student (id, entry_date, class_id) VALUES ('20a31e0d-b395-4b99-ab40-a385f4cce7b1', '2020-10-18', '0ea0a09f-98d2-4491-8608-a68cb8001974');
INSERT INTO student (id, entry_date, class_id) VALUES ('4525deff-02a2-4ed2-8498-d920e78b1163', '2020-10-18', '0ea0a09f-98d2-4491-8608-a68cb8001974');
INSERT INTO student (id, entry_date, class_id) VALUES ('98ae0a8f-486e-4957-8f61-412116e9fbb6', '2020-10-18', '0ea0a09f-98d2-4491-8608-a68cb8001974');
INSERT INTO student (id, entry_date, class_id) VALUES ('31d4d3f7-4bc4-470c-a62f-c8775db609a4', '2020-10-18', '0ea0a09f-98d2-4491-8608-a68cb8001974');

-- -----------------------------------------------------
-- `GRADE`
-- -----------------------------------------------------
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('c76d1b7e-9080-439f-aabc-1598ef3b8cc6', '8', 'a3540720-d99c-4088-a4f1-6898d8e35695', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('c91f6638-ceb4-469c-a19e-f39d5a052be3', '10', '647d4460-69bb-4697-8fa8-51faf26dbd3e', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('42c3ab88-eed1-4ed4-8d6b-f153214b01a7', '9', 'bb0f6fbc-60d2-42c7-91b9-f991355b8758', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('0b72a37a-9c02-431a-9f63-f74531d20778', '8', 'a3c26711-2cf7-40bc-8fef-99da0f0c022a', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('13c05c17-f99d-42d7-9e95-6a480ad9c6a5', '10', '9c5d2eba-5c40-4361-8022-409055310fb4', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('a5d7f475-3dce-4c72-9018-f170bf1fa397', '7', '3bfec498-91a3-4162-b52d-fb8567dc3553', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('0c486b3c-229d-42cc-bfb3-02b3c0255bdb', '10', '24a4e305-14ae-4720-a348-59f0f05a6401', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('2102340b-dd33-49f3-a9c7-ae548a128491', '8', '20a31e0d-b395-4b99-ab40-a385f4cce7b1', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('585a9103-4f85-4fe7-b325-3aefa2f593de', '9', '4525deff-02a2-4ed2-8498-d920e78b1163', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('d0d50313-d047-4be6-a9b2-1170e4e36ad3', '7', '98ae0a8f-486e-4957-8f61-412116e9fbb6', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('84e3e1b2-32d9-42cd-b9c2-1290c9d0d1d7', '6', '31d4d3f7-4bc4-470c-a62f-c8775db609a4', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');

INSERT INTO grade (id, value, student_id, subject_id) VALUES ('9eda4989-c7ab-4999-8359-097076c4079c', '10', 'a3540720-d99c-4088-a4f1-6898d8e35695', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('062b905b-1152-4df9-9161-dd1ae4a8d764', '9', '647d4460-69bb-4697-8fa8-51faf26dbd3e', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('6d12a46f-af1c-42c2-98f7-801abfdd2cd5', '8', 'bb0f6fbc-60d2-42c7-91b9-f991355b8758', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('9d88debf-b5ee-41fb-baa9-e5a7b64e337d', '6', 'a3c26711-2cf7-40bc-8fef-99da0f0c022a', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('88b224eb-23f3-41c2-9c03-7f97f5470807', '7', '9c5d2eba-5c40-4361-8022-409055310fb4', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('874027cb-3f2b-4a5c-8f29-9a2f351d6a74', '8', '3bfec498-91a3-4162-b52d-fb8567dc3553', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('a937f01b-d844-4eb6-8449-a234e7f63bc8', '9', '24a4e305-14ae-4720-a348-59f0f05a6401', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('57a61b8a-1a0d-4644-ad7a-68c274dc61e6', '10', '20a31e0d-b395-4b99-ab40-a385f4cce7b1', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('587f795f-3e7b-42ae-9d0f-9b9e0801e013', '7', '4525deff-02a2-4ed2-8498-d920e78b1163', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('e18ec370-f05d-41c4-b5dc-5a9f0ad1395b', '8', '98ae0a8f-486e-4957-8f61-412116e9fbb6', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('4bfa483d-8473-4938-ae09-48c4e122c672', '7', '31d4d3f7-4bc4-470c-a62f-c8775db609a4', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');

INSERT INTO grade (id, value, student_id, subject_id) VALUES ('d710ecd9-6172-43cf-952b-0815a44e9ccf', '6', 'a3540720-d99c-4088-a4f1-6898d8e35695', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('7b060b90-a3eb-4ee3-9f60-ed56581183f0', '8', '647d4460-69bb-4697-8fa8-51faf26dbd3e', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('530f6046-f962-4ed8-aeca-847e340b78eb', '3', 'bb0f6fbc-60d2-42c7-91b9-f991355b8758', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('b9b9c6cc-cc77-4dd8-adb8-4a8c286f0966', '9', 'a3c26711-2cf7-40bc-8fef-99da0f0c022a', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('bfdee4fc-4021-419c-876f-01ded8c5c3b5', '8', '9c5d2eba-5c40-4361-8022-409055310fb4', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('8ef3acd8-714a-4500-a630-c9b266416af9', '9', '3bfec498-91a3-4162-b52d-fb8567dc3553', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('520a6c12-9f83-490d-b040-70ec3f10db3e', '7', '24a4e305-14ae-4720-a348-59f0f05a6401', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('077ea85d-1ddc-4594-a08b-8d5a63c4852d', '6', '20a31e0d-b395-4b99-ab40-a385f4cce7b1', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('265f46e9-c150-450a-b6d2-6208163b7789', '10', '4525deff-02a2-4ed2-8498-d920e78b1163', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('be8f43e3-f326-4f49-a64e-fdcb36281508', '9', '98ae0a8f-486e-4957-8f61-412116e9fbb6', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');
INSERT INTO grade (id, value, student_id, subject_id) VALUES ('b280c8e0-282d-4c98-8052-aa6da0dfa512', '7', '31d4d3f7-4bc4-470c-a62f-c8775db609a4', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');


