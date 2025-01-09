

CREATE VIEW pasageri_pe_localitate_si_ruta AS
SELECT
    CONCAT(l2.nume, '-', l3.nume) AS ruta,
    l.nume AS localitate_plecare,
    COUNT(b.id_bilet) AS numar_pasageri
FROM
    transport_persoane.bilete b
        JOIN
    transport_persoane.orare o ON b.id_orar = o.id_orar
        JOIN
    transport_persoane.localitati l ON o.id_localitate_plecare = l.id_localitate
        JOIN transport_persoane.rute r ON o.id_ruta = r.id_ruta
        JOIN transport_persoane.localitati l2 ON r.id_localitate_inceput = l2.id_localitate
        JOIN transport_persoane.localitati l3 ON r.id_localitate_destinatie = l3.id_localitate
GROUP BY
    ruta, l.nume;

CREATE VIEW venituri_pe_rute AS
SELECT
    CONCAT(l1.nume, '-', l2.nume) AS ruta,
    SUM(CASE WHEN WEEK(b.timp_cumparare, 1) = WEEK('2024-12-16', 1) THEN p.pret ELSE 0 END) AS venit_saptamanal,
    SUM(CASE WHEN MONTH(b.timp_cumparare) = 12 AND YEAR(b.timp_cumparare) = 2024 THEN p.pret END) AS venit_lunar,
    SUM(CASE WHEN YEAR(b.timp_cumparare) = 2024 THEN p.pret END) AS venit_anual
FROM
    transport_persoane.bilete b
        JOIN
    transport_persoane.orare o ON b.id_orar = o.id_orar
        JOIN
    transport_persoane.rute r ON o.id_ruta = r.id_ruta
        JOIN
    transport_persoane.preturi p ON b.id_pret = p.id_pret
        JOIN transport_persoane.localitati l1 ON r.id_localitate_inceput = l1.id_localitate
        JOIN transport_persoane.localitati l2 ON r.id_localitate_destinatie = l2.id_localitate
GROUP BY
    r.id_ruta;

CREATE VIEW numar_autobuze_dupa_status AS
SELECT
    status,
    COUNT(*) AS numar_autobuze
FROM
    transport_persoane.autobuze
GROUP BY
    status;