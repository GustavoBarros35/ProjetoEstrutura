# ProjetoEstrutura

##  O projeto consiste das seguintes fases:

Preparação do dataset compreende um registro histórico de ocorrência de COVID-19 para todas as cidades e estados do Brasil. Você deve baixar a planilha localmente para poder processá-la no seu código Java. Atenção, quando descompacta se torna algo bem maior. Você deve tratar apenas com os dados mais atuais (tem um campo chamado "É a última atualização?" ou "is_last" que deve eestar marcado como True). Valores antigos não interessam, você deve utilizar apenas dados não repetidos (existe um campo que indica isso "Dado repetido?").
Gerar um arquivo formatado para ser processado na próxima fase, análise dos algoritmos de ordenação Implemente e utilize todos os algoritmos de ordenação estudados (Selection Sort, Insertion Sort, Merge Sort, Quick Sort, QuickSort com Mediana de 3, counting, e HeapSort) para ordenar os registros de acordo com os seguintes parâmetros:

•	Ordenação crescente por quantidade acumulada de óbitos;

•	Ordenação crescente por quantidade acumulada de casos;

•	Ordenação crescente por ordem alfabética pelo nome das cidades.

Cada arquivo de saída de ordenação deve ser gerado com base no método de ordenação e no elemento ordenado. Por exemplo, para o quick sort devem ser gerado 3 arquivos: qSort_ordena_obitos.csv e qSort_ordena_casos.csv, qSort_ordena_cidades.csv. Isso deve continuar para cada um dos métodos de ordenação. Para cada algoritmo, registre o tempo necessário para ordenar o vetor de senhas (em milissegundos).

## Pré-Requisitos

Possuir uma JRE ou JDK do Java, instalada no seu SO(sistema
operacional) de nível 1.8 ou superior.

Possuir uma IDE de Desenvolvimento Java, uma indicação é a IDE
&quot;Eclipse&quot; desenvolvida pela própria IBM.

### Execução

1  Clone esse repositório, baixando o arquivo zip dele, ou até mesmo usando o comando "git clone" + o caminho gerado através do botão "Code" visível no canto superior dessa tela.

2  Abra o projeto que foi clonado no ambiente de desenvolvimento citado, ou
outro a sua escolha que suporte execução de programas em Java.

3  Adicione o arquivo “caso.csv” a pasta dados localizado dentro de src.

4  Selecione a função da sua IDE "Build and Run" ou somente "Run", o próprio código se encarregará de encontrar os caminhos para salvar os dados que serão gerados.

5  Após o programa parar, todos os dados já estarão disponíveis para serem acessados dentro da pasta "dados" que está no mesmo repositório que o arquivo utils, bem como o tempo em milissegundos de cada execução.

##  Observação

Os arquivos gerados, são as ordenações para cada tipo de algoritmo e tipo de caso gerado, todos serão criados dentro da mesma pasta em que os arquivos brutos de dados estão.
