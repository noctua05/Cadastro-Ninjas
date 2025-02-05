-- Migrations para adicionar a coluna de RANK na tabela de cadastros

ALTER TABLE TB_ninjas
ADD COLUMN rank VARCHAR(255);