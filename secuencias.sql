CREATE SEQUENCE per_id_seq
START WITH 3
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE fac_cab_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE fac_det_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE pro_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE cat_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE com_prov_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

SELECT *
FROM aba_categorias;
ALTER TABLE aba_productos MODIFY pro_codigo_barras VARCHAR2(14) NULL;

DESC aba_productos;
