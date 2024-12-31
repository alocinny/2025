public class Txt {

    public static void main(String[] args) {
        int larguraMaxima = 80;

        // Texto definido diretamente na classe
        String texto = """
        Se eu puder ter um pedido a mais, guarde o melhor que tivemos. -água-viva

        Oi. 
        Eu sei que foi meio aleatório esse programa, mas eu quis juntar o útil ao agradável. As palavras que virão a seguir ficaram na minha cabeça o ano todo, mas não saíram dos meus pensamentos porque não queria misturar as coisas e atrapalhar seu desempenho na prova do ENEM. Agora que as férias chegaram, por respeito a mim, vou falar tudo que deixei preso durante meses...

        Eu não imaginei que fosse amar fosse ser um simples tão complexo. Com você eu aprendi que amar não é beijar, abraçar ou estar o tempo todo junto. Na verdade eu entendi que eu não precisava de nada disso pra transmitir o que eu sentia. Mas eu me sentia pressionada a seguir os padrões de demonstração de afeto, e isso acabou transformando o simples em um emaranhado de sentimentos misturados. Hoje vejo que não era preciso de tudo aquilo, era só deixar o gostar existir em sua forma mais pura, e aproveitar o sentimento bom de compartilhar momentos com alguém que você gosta. Eu me culpo por ter me guiado por esse caminho, que no final não fez nada além de gerar ansiedade. Me pergunto todos os dias onde estaria hoje se tivesse sido fiel aos meus sentimentos, se não tivesse me desesperado e deixado a ansiedade dominar minhas ações. Me questiono a todo momento em que ponto me perdi e como consequência soltei sua mão e te fiz partir. Eu nunca deixei de te amar, e, sinceramente, falo em alto e bom tom que não sei se um dia vou deixar. Eu não espero uma resposta, nem quero que você se sinta confusa ou pense muito sobre isso. Leve esse texto como um pedaço dos meus pensamentos e sentimentos. Feliz ano novo. Espero que, assim como foi em 2024, 2025 seja marcado pela sua presença.
        """;

        if (texto == null || texto.isEmpty()) {
            System.out.println("Erro: texto vazio.");
            return;
        }

        exibirTextoGradativamente(texto, larguraMaxima);
    }

    private static void exibirTextoGradativamente(String texto, int larguraMaxima) {
        String[] palavras = texto.split(" ");
        StringBuilder linhaAtual = new StringBuilder();

        for (String palavra : palavras) {
            if (linhaAtual.length() + palavra.length() + 1 > larguraMaxima) {
                imprimirComDelay(linhaAtual.toString());
                linhaAtual = new StringBuilder();
            }
            linhaAtual.append(palavra).append(" ");
        }

        if (!linhaAtual.isEmpty()) {
            imprimirComDelay(linhaAtual.toString());
        }
    }

    private static void imprimirComDelay(String texto) {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(90); // Delay entre caracteres
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}