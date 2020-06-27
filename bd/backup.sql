BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Registro" (
	"codigoreg"	INTEGER NOT NULL UNIQUE,
	"nome"	TEXT NOT NULL,
	"email"	TEXT,
	"senha"	TEXT NOT NULL,
	PRIMARY KEY("codigoreg")
);
CREATE TABLE IF NOT EXISTS "produto" (
	"codigopro"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"nome"	TEXT NOT NULL,
	"marca"	TEXT NOT NULL,
	"valor"	double NOT NULL
);
INSERT INTO "Registro" ("codigoreg","nome","email","senha") VALUES (1,'kemi',NULL,'kemi');
INSERT INTO "produto" ("codigopro","nome","marca","valor") VALUES (1,'fsafa','adasd',0.0);
INSERT INTO "produto" ("codigopro","nome","marca","valor") VALUES (2,'das','adas',0.0);
COMMIT;
