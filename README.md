# exercicios_manipulacao_arq_gzip

1) Crie um programa em Java que gere um arquivo chamado exemplo.txt, utilizando a classe FileOutputStream, e escreva no arquivo o texto “Olá Java”.
 Em seguida, implemente no mesmo programa (ou em um segundo programa) a compactação desse arquivo para o formato .gz, utilizando a classe GZIPOutputStream, gerando um novo arquivo compactado. Realize o tratamento adequado de exceções e garanta o fechamento correto dos fluxos de entrada e saída.
----

2) Implemente uma classe em Java chamada Compactar que utilize as classes FileInputStream, FileOutputStream e GZIPOutputStream para compactar todos os arquivos de uma pasta. O programa deve receber um path informado pelo usuário, identificar os arquivos contidos na última pasta desse caminho e gerar, para cada arquivo, uma versão compactada no formato .gz. Considere apenas arquivos comuns (ignore subpastas) e realize o tratamento adequado de exceções.
----
