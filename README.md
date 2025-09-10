# Atividade Prática: Consumo de API em Java

> Projeto em **Java** para consumir dados de uma API externa (demonstração em sala de aula) através de requisições HTTP e processamento de JSON.

---

## 🎯 Objetivo

Exercitar o consumo de APIs em **Java** a partir de:
1. Fazer requisições HTTP para uma API.
2. Receber e processar a resposta JSON.
3. Exibir os dados de forma organizada e compreensível.

---

## ⚙️ Funcionalidades

- Realiza chamadas HTTP (GET) para uma API específica (estrutura à escolha).
- Processa resposta JSON e exibe conteúdos relevantes.
- Código modular que permite fácil adaptação para outras APIs ou endpoints.

---

## 🚀 Como executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/thialms/Atividade_Pratica_Consumo_de_API.git
   ```
2. Abra o projeto em sua IDE Java (IntelliJ, Eclipse, VS Code etc.).
3. Configure o endpoint da API dentro do código (ou via arquivo de configuração, se implementado).
4. Compile e execute:
   ```bash
   mvn clean compile exec:java
   ```
   *(ou execute diretamente pela sua IDE)*

---

## 🛠️ Tecnologias utilizadas

- **Java** como linguagem principal.
- Cliente HTTP: `HttpURLConnection` ou biblioteca similar.
- Biblioteca para parsing JSON, **Gson**.
- Estrutura de projeto Java padrão (pasta `src/` com pacotes e classes).

---

## 📂 Estrutura de diretórios

- `src/`: código-fonte Java
- `.idea/`: configuração da IDE (IntelliJ), se aplicável
- `ConsumoApi.iml`: arquivo de módulo da IDE (se presente)
- `.gitignore`: arquivos ignorados no Git
