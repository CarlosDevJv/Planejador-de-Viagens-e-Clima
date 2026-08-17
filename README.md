# ✈️ Planejador de Viagens & Clima

> **Status do Projeto:** Em Desenvolvimento 

API RESTful para criação e gerenciamento de roteiros de viagem, permitindo associar cidades e hospedagens com consumo integrado de dados climáticos e geográficos em tempo real.

---

## 🚀 Sobre o Projeto

O **Planejador de Viagens e Clima** é um projeto backend desenvolvido para praticar a construção de APIs robustas em Java com Spring Boot, com foco em otimização de consultas e integração eficiente com serviços externos.

### 💡 Principais Objetivos de Aprendizado & Prática
* **Enriquecimento de DTOs:** Combinação de dados locais persistidos no PostgreSQL com dados dinâmicos de APIs externas.
* **Resiliência e Tratamento de Exceções:** Manipulação robusta de falhas e *timeouts* no consumo de serviços de terceiros.
* **Spring Data JPA:** Modelagem relacional e otimização de consultas ao banco de dados.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **Framework:** Spring Boot 3+ (Spring Data JPA, Spring Web)
* **Banco de Dados:** PostgreSQL
* **APIs Externas:**
    * [ViaCEP](https://viacep.com.br/) – Autocompletado de endereços brasileiros.
    * [OpenMeteo API](https://open-meteo.com) – Previsão do tempo e clima atual dos destinos.

---

## 🎯 Funcionalidades

- [x] Estrutura inicial do projeto e entidades do banco de dados
- [x] Integração com ViaCEP para busca automática de endereço
- [x] Integração com OpenMeteo para busca automática de clima
- [ ] Cadastro e gerenciamento de roteiros de viagem e hospedagens
- [ ] Integração com OpenWeatherMap para previsão do tempo no destino
- [ ] Tratamento global de exceções para falhas em chamadas HTTP externas

---

[//]: # (## 💻 Como Rodar o Projeto Localmente)

[//]: # ()
[//]: # (### Pré-requisitos)

[//]: # (* Java 17 ou superior)

[//]: # (* Maven)

[//]: # (* PostgreSQL)

[//]: # (* Chave de API ativa no [OpenWeatherMap]&#40;https://openweathermap.org/api&#41;)

[//]: # ()
[//]: # (### Passos)

[//]: # ()
[//]: # (1. **Clone o repositório:**)

[//]: # (   ```bash)

[//]: # (   git clone [https://github.com/seu-usuario/planejador-viagens-clima.git]&#40;https://github.com/seu-usuario/planejador-viagens-clima.git&#41;)

[//]: # (   cd planejador-viagens-clima)