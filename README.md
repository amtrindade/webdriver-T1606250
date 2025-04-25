# Projeto desenvolvido no curso de Automação de Testes com WebDriver T:1606250

## Documentação de Instalação e Setup do Projeto

### Pré-requisitos

Certifique-se de ter os seguintes itens instalados em sua máquina:
- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [Eclipse IDE](https://www.eclipse.org/downloads/)

### Passos para Instalação

1. **Clone o repositório:**
    ```bash
    git clone https://github.com/seu-usuario/cursowebdriver.git
    cd cursowebdriver
    ```

2. **Importe o projeto no Eclipse:**
    - Abra o Eclipse.
    - Vá em `File > Import > Maven > Existing Maven Projects`.
    - Selecione o diretório do projeto clonado.
    - Clique em `Finish`.

3. **Instale as dependências:**
    - No terminal, dentro do diretório do projeto, execute:
      ```bash
      mvn clean install
      ```

4. **Configure o WebDriver:**
    - Baixe o WebDriver correspondente ao navegador que deseja usar (ex.: [ChromeDriver](https://chromedriver.chromium.org/)).
    - Adicione o caminho do WebDriver ao `PATH` do sistema.

### Executando os Testes

1. Certifique-se de que o WebDriver está configurado corretamente.
2. No terminal, execute:
    ```bash
    mvn test
    ```

### Problemas Comuns

- **Erro de versão do Java:** Verifique se o Java JDK 11+ está instalado e configurado no `PATH`.
- **Dependências não resolvidas:** Execute `mvn clean install` novamente.


