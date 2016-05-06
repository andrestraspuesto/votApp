INSERT INTO aplicacion (id,activa, email) VALUES (1,1,'mockActiva@test.com');
INSERT INTO aplicacion (id,activa, email) VALUES (2,0,'mockInactiva@test.com');
INSERT INTO item (id,uri, aplicacion_id, puntuacion_min, puntuacion_max, num_votos_max) 
values (1,'item_1_ap_1',1,0,10,1);
INSERT INTO item (id,uri, aplicacion_id, puntuacion_min, puntuacion_max, num_votos_max) 
values (2,'item_2_ap_1',1,0,10,1);
INSERT INTO votante (id, activo, aplicacion_id) values (1, 1, 1);
INSERT INTO votante (id, activo, aplicacion_id) values (2, 1, 1);
INSERT INTO votante (id, activo, aplicacion_id) values (3, 1, 1);
INSERT INTO votante (id, activo, aplicacion_id) values (4, 1, 1);
INSERT INTO votante (id, activo, aplicacion_id) values (5, 1, 1);
INSERT INTO votante (id, activo, aplicacion_id) values (6, 1, 1);
INSERT INTO votante_item (id, votante_id, item_id, puntuacion, fecha) 
values (1, 1, 1, 5, parseDateTime('2015/03/12 23:12:12', 'yyyy/MM/dd HH:mm:ss'));
INSERT INTO votante_item (id, votante_id, item_id, puntuacion, fecha) 
values (2, 2, 1, 10, parseDateTime('2015/04/12 23:12:12', 'yyyy/MM/dd HH:mm:ss'));
INSERT INTO votante_item (id, votante_id, item_id, puntuacion, fecha) 
values (3, 3, 1, 8, parseDateTime('2015/05/12 23:12:12', 'yyyy/MM/dd HH:mm:ss'));
