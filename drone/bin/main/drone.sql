-- 드론 데이터
insert into drone(uuid, model_name, loc, latitude, longitude, is_message, is_use) 
values(201210325, 'KAZA-556699', '대전 충정로 136', '36.3432473', '127.4487079', true, true);

insert into drone(uuid, model_name, loc, latitude, longitude, is_message, is_use) 
values(101210777, 'SAMA-931207', '대전 중앙로121번길 20', '36.3286904', '127.4229992', true, true);

insert into drone(uuid, model_name, loc, latitude, longitude, is_message, is_use) 
values(211016700, 'AJJK-200489', '대전 진잠로92번길 24', '36.2996845', '127.3169115', true, true);

-- 드론 운행정보
insert into drone_driving(uuid, start_at, end_at, driving_distance)
values(201210325, '2022-11-13 14:02:56', '2022-11-13 15:00:56', 8.5);
insert into drone_driving(uuid, start_at, end_at, driving_distance)
values(101210777, '2022-11-13 09:30:00', null, 0);

-- 드론 운행상세정보
insert into drone_driving_history(driving_no, latitude, longitude, create_at)
values(1, '36.3286904', '127.4229992', '2022-11-13 14:02:56');
insert into drone_driving_history(driving_no, latitude, longitude, create_at)
values(1, '36.3325226', '127.4338474', '2022-11-13 14:11:30');
insert into drone_driving_history(driving_no, latitude, longitude, create_at)
values(1, '36.3499999', '127.4370503', '2022-11-13 14:22:00');
insert into drone_driving_history(driving_no, latitude, longitude, create_at)
values(1, '36.3577778', '127.4063889', '2022-11-13 14:41:40');
insert into drone_driving_history(driving_no, latitude, longitude, create_at)
values(1, '36.3711638', '127.3883444', '2022-11-13 14:50:16');
insert into drone_driving_history(driving_no, latitude, longitude, create_at)
values(1, '36.4240196', '127.3958129', '2022-11-13 15:00:56');