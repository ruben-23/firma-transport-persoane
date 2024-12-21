
INSERT INTO firma ( nume, adresa, numar_telefon, email)
VALUES ("Firmă Transport Persoane", "Strada Cuza Vodă nr. 28, Baia Mare, Maramureș", "+40 262 123 456", "firmatransport@gmail.com");

INSERT INTO localitati (nume) 
VALUES	('Baia Mare'),
		('Tăuții-Măgherăuș'),
        ('Bușag'),
        ('Cicârlău'),
        ('Ilba'),
        ('Săbișa'),
        ('Seini');

INSERT INTO rute (id_localitate_inceput, id_localitate_destinatie)
VALUES (1, 7); -- Baia Mare - Seini

INSERT INTO localitati_intermediare (id_ruta, id_localitate, ordine)
VALUES (1, 2, 1), -- Tautii-Magheraus
(1, 3, 2), -- Busag
(1, 4, 3), -- Cicarlau
(1, 5, 4), -- Ilba
(1, 6, 5); -- Sabisa

INSERT autobuze (numar_inmatriculare, status, capacitate, id_ruta, id_firma) 
VALUES ('MM-19-FTP', 'Indisponibil', 50, 1, 1),
('MM-91-FTP', 'Disponibil', 40, NULL, 1),
('MM-79-FTP', 'Indisponibil', 35, 1, 1);

INSERT INTO preturi (pret, id_localitate, id_ruta) 
VALUES	(12, 1, 1),  -- Pret pentru ruta Baia Mare - Seini, localitatea Baia Mare
(11, 2, 1),  -- Pret pentru ruta Baia Mare - Seini, localitatea Tautii-Magheraus
(7, 3, 1),  -- Pret pentru ruta Baia Mare - Seini, localitatea Busag
(5, 4, 1),  -- Pret pentru ruta Baia Mare - Seini, localitatea Cicarlau
(3, 5, 1),  -- Pret pentru ruta Baia Mare - Seini, localitatea Ilba
(2, 6, 1);  -- Pret pentru ruta Baia Mare - Seini, localitatea Sabisa

INSERT INTO orare (ora_plecare, zi, id_localitate_plecare, id_ruta) 
VALUES	('08:00:00', 'Luni', 1, 1),  -- Baia Mare
('08:10:00', 'Luni', 2, 1),  -- Tautii-Mageheraus
('08:15:00', 'Luni', 3, 1),  -- Busag
('08:20:00', 'Luni', 4, 1),  -- Cicarlau
('08:25:00', 'Luni', 5, 1),  -- Ilba
('08:30:00', 'Luni', 6, 1);  -- Sabisa

INSERT INTO bilete (id_pret,id_orar)
VALUES	(1, 1),  -- bilet pentru ruta BM-Seini, cumparat din localitatea BM
          (2, 2),  -- bilet pentru ruta BM-Seini, cumparat din localitatea BM
          (3, 3),  -- bilet pentru ruta BM-Seini, cumparat din localitatea BM
          (4, 4),  -- bilet pentru ruta BM-Seini, cumparat din localitatea BM
          (5, 5),  -- bilet pentru ruta BM-Seini, cumparat din localitatea BM
          (6, 6);  -- bilet pentru ruta BM-Seini, cumparat din localitatea BM

INSERT INTO feedbackuri (tip, mesaj, id_firma)
VALUES ('Sugestie', 'Va rog să adăugați și ruta Baia Mare - Șomcuta Mare', 1);