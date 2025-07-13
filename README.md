# Documentação do Tradutor Binário

## Visão Geral
O Tradutor Binário é uma aplicação Java que permite converter texto para código binário e vice-versa. A aplicação oferece uma interface gráfica amigável com recursos como cópia para área de transferência, alternância de tema (claro/escuro) e redimensionamento responsivo.

## Funcionalidades Principais
- Conversão de texto para código binário
- Conversão de código binário para texto
- Limpeza dos campos de texto
- Cópia do conteúdo para área de transferência
- Alternância entre temas claro e escuro
- Interface responsiva que se adapta ao tamanho da janela
- Mensagens de status informativas

## Requisitos do Sistema
- Java 11 ou superior
- Maven (para construção do projeto)

## Estrutura do Projeto
```
tradutor-binario/
├── src/
│   └── main/
│       └── java/
│           └── javaricci/
│               └── com/
│                   └── br/
│                       └── TradutorBinario.java
├── pom.xml
```

## Dependências
- FlatLaf (3.2.5) - Para a interface moderna com temas claro/escuro
- JUnit (4.13.2) - Para testes (não implementados na versão atual)

## Como Compilar e Executar

### Usando Maven:
1. Clone o repositório
2. Navegue até o diretório do projeto
3. Execute:
   ```bash
   mvn clean package
   java -jar target/tradutor-binario-1.0.0.jar
   ```

### Executando diretamente:
```bash
javac -cp "flatlaf-3.2.5.jar" src/main/java/javaricci/com/br/TradutorBinario.java
java -cp "flatlaf-3.2.5.jar;src/main/java" javaricci.com.br.TradutorBinario
```

## Como Usar
1. **Texto → Binário**:
   - Digite o texto na área "Texto"
   - Clique no botão "Texto → Binário"
   - O código binário equivalente aparecerá na área "Binário"

2. **Binário → Texto**:
   - Digite o código binário (grupos de 8 bits separados por espaços) na área "Binário"
   - Clique no botão "Binário → Texto"
   - O texto decodificado aparecerá na área "Texto"

3. **Outras Funcionalidades**:
   - Use os botões "Copiar" para copiar o conteúdo de cada área
   - Clique em "Limpar Tudo" para apagar ambos os campos
   - Use o botão de tema (🌙/☀️) para alternar entre os modos escuro e claro

## Detalhes de Implementação

### Classe Principal: `TradutorBinario`
- Herda de `JFrame` para criar a janela principal
- Utiliza `FlatLaf` para a aparência moderna
- Contém dois `JTextArea` para entrada/saída de texto e binário
- Implementa listeners para todos os botões e eventos de redimensionamento

### Métodos Principais:
1. `converterTextoParaBinario()`:
   - Converte cada caractere para seu valor binário de 8 bits
   - Adiciona zeros à esquerda quando necessário

2. `converterBinarioParaTexto()`:
   - Valida que o input contém apenas 0s e 1s
   - Converte grupos de 8 bits para caracteres Unicode

3. `alternarTema()`:
   - Alterna entre `FlatLightLaf` e `FlatDarkLaf`
   - Atualiza o ícone e tooltip do botão de tema

4. `ajustarLayout()`:
   - Ajusta o tamanho da fonte baseado no tamanho da janela

## Configuração do Maven
O arquivo `pom.xml` configura:
- Java 11 como versão de compilação
- Dependências do FlatLaf e JUnit
- Plugin `maven-shade-plugin` para criar um JAR executável com todas as dependências

## Licença
Este projeto está licenciado sob a licença MIT.

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Screenshots (opcional)
(Incluir screenshots da aplicação em funcionamento, se disponíveis)

## Roadmap
- [ ] Adicionar suporte para outros sistemas numéricos (hexadecimal, octal)
- [ ] Implementar testes unitários
- [ ] Adicionar opção de salvar/abrir arquivos
- [ ] Internacionalização (suporte a múltiplos idiomas)

## Problemas Conhecidos
- A validação de binário poderia ser mais robusta
- O redimensionamento poderia ser mais fluido
