package Exercicio3;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class FaturamentoDistribuidora {

    public static void main(String[] args) {
        try {
            // Ler o arquivo XML
            File file = new File("faturamento.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("dia");

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0.0;
            int diasComFaturamento = 0;

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    double faturamentoDiario = Double.parseDouble(element.getAttribute("valor"));

                    // Ignorar dias sem faturamento
                    if (faturamentoDiario > 0) {
                        if (faturamentoDiario < menorFaturamento) {
                            menorFaturamento = faturamentoDiario;
                        }
                        if (faturamentoDiario > maiorFaturamento) {
                            maiorFaturamento = faturamentoDiario;
                        }

                        somaFaturamento += faturamentoDiario;
                        diasComFaturamento++;
                    }
                }
            }

            double mediaFaturamento = somaFaturamento / diasComFaturamento;

            // Calcular o número de dias com faturamento superior à média
            int diasAcimaDaMedia = 0;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    double faturamentoDiario = Double.parseDouble(element.getAttribute("valor"));

                    if (faturamentoDiario > mediaFaturamento) {
                        diasAcimaDaMedia++;
                    }
                }
            }

            // Exibir resultados
            System.out.println("Menor faturamento: " + menorFaturamento);
            System.out.println("Maior faturamento: " + maiorFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
