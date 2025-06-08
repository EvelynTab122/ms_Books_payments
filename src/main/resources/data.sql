INSERT INTO orden (orden_id, fecha, estado, total)
VALUES (1, '2025-06-07', 'CONFIRMADA', 75.970);

INSERT INTO orden (orden_id, fecha, estado, total)
VALUES (2, '2025-06-17', 'CONFIRMADA', 45.900);

INSERT INTO orden_item (id, libro_id, cantidad, precio, subtotal, orden_id)
VALUES (1, 2, 1, 25.990, 25.990, 1);

INSERT INTO orden_item (id, libro_id, cantidad, precio, subtotal, orden_id)
VALUES (2, 5, 2, 24.990, 49.980, 1);
