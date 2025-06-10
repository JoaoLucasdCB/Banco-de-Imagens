--- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS banco_imagens;
USE banco_imagens;

-- Criação da tabela de imagens
CREATE TABLE IF NOT EXISTS imagens (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    caminho_arquivo VARCHAR(500) NOT NULL,
    descricao TEXT,
    data_upload DATETIME DEFAULT CURRENT_TIMESTAMP,
    tamanho INT,
    tipo VARCHAR(100)
);