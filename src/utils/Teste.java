package utils;

import java.util.Date;

public class Teste {
	public static void main(String[] args) {
		
		String pathDadosTotal = System.getProperty("user.dir");
		String pathBase = pathDadosTotal + "\\src\\dados\\caso.csv";
		
		
		// Trajeto para a limpeza do arquivo	
		String path_Arquivo_Dados_Limpos = pathDadosTotal + "\\src\\dados\\dados_limpos.csv";
		
		
		//Formando a classe de armazenar e limpando o arquivo 
		ReadWrite armazena = new ReadWrite();
		armazena.Read(pathBase);
		armazena.Write(path_Arquivo_Dados_Limpos, armazena.getData());
		
		
		// Criando trajeto dos arquivos para ordenar
		
		// Insertion Sort
		String path_Insertion_Deaths = pathDadosTotal + "\\src\\dados\\InsertionSort_ordena_obitos.csv";
		String path_Insertion_Confirmeds = pathDadosTotal + "\\src\\dados\\InsertionSort_ordena_confirmados.csv";
		String path_Insertion_City = pathDadosTotal + "\\src\\dados\\InsertionSort_ordena_cidades.csv";
		
		
		// Ordanação Insertion
		
		Sort sort = new Sort();
		
		sort.insertionDeaths(armazena.getData());
		armazena.Write(path_Insertion_Deaths, armazena.getData());
		
		sort.insertionConfirmed(armazena.getData());
		armazena.Write(path_Insertion_Confirmeds, armazena.getData());
		
		sort.insertionCity(armazena.getData());
		armazena.Write(path_Insertion_City, armazena.getData());
		
		System.out.println("Insertion ordenado \n");
		
		
		// Criando trajeto dos arquivos para ordenar
		
		// Selection Sort
		String path_Selection_Deaths = pathDadosTotal + "\\src\\dados\\SelectionSort_ordena_obitos.csv";
		String path_Selection_Confirmeds = pathDadosTotal + "\\src\\dados\\SelectionSort_ordena_confirmados.csv";
		String path_Selection_City = pathDadosTotal + "\\src\\dados\\SelectionSort_ordena_cidades.csv";
				
				
		// Ordanação Selection
				
		armazena.Read(path_Arquivo_Dados_Limpos);
			
		sort.selectionDeaths(armazena.getData());
		armazena.Write(path_Selection_Deaths, armazena.getData());
				
		sort.selectionConfirmed(armazena.getData());
		armazena.Write(path_Selection_Confirmeds, armazena.getData());
				
		sort.selectionCity(armazena.getData());
		armazena.Write(path_Selection_City, armazena.getData());
				
		System.out.println("Selection ordenado \n");
		
		
		// Criando trajeto dos arquivos para ordenar
		
		// Merge Sort
		String path_Merge_Deaths = pathDadosTotal + "\\src\\dados\\MergeSort_ordena_obitos.csv";
		String path_Merge_Confirmeds = pathDadosTotal + "\\src\\dados\\MergeSort_ordena_confirmados.csv";
		String path_Merge_City = pathDadosTotal + "\\src\\dados\\MergeSort_ordena_cidades.csv";
						
						
		// Ordanação Merge
						
		armazena.Read(path_Arquivo_Dados_Limpos);
		
		long tempoinicial = new Date().getTime();
		sort.mergeDeaths(armazena.getData(), 0, armazena.getData().length - 1);
		
		long tempofinal = new Date().getTime();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de processamento MergeSort por óbito: " + tempototal + "ms");
		
        armazena.Write(path_Merge_Deaths, armazena.getData());
        
        long tempoinicial2 = new Date().getTime();
		sort.mergeConfirmed(armazena.getData(), 0, armazena.getData().length - 1);
		long tempofinal2 = new Date().getTime();
        long tempototal2 = tempofinal2 - tempoinicial2;
        System.out.println("Tempo de processamento MergeSort por casos confirmados: " + tempototal2 + "ms");	
        
        armazena.Write(path_Merge_Confirmeds, armazena.getData());
        
        long tempoinicial3 = new Date().getTime();
		sort.mergeCity(armazena.getData(), 0, armazena.getData().length - 1);
		long tempofinal3 = new Date().getTime();
        long tempototal3 = tempofinal3 - tempoinicial3;
        System.out.println("Tempo de processamento MergeSort por cidades: " + tempototal3 + "ms");
		
		armazena.Write(path_Merge_City, armazena.getData());
				
		System.out.println("MergeSort ordenado \n");
		
		
		
		// Criando trajeto dos arquivos para ordenar
		
		// QuickSort
		String path_Quick_Deaths = pathDadosTotal + "\\src\\dados\\QuickSort_ordena_obitos.csv";
		String path_Quick_Confirmeds = pathDadosTotal + "\\src\\dados\\QuickSort_ordena_confirmados.csv";
		String path_Quick_City = pathDadosTotal + "\\src\\dados\\QuickSort_ordena_cidades.csv";
								
								
		// Ordanação QuickSort
								
		armazena.Read(path_Arquivo_Dados_Limpos);
				
		tempoinicial = new Date().getTime();
		
		sort.quickDeaths(armazena.getData(), 0, armazena.getData().length - 1);
				
		tempofinal = new Date().getTime();
		tempototal = tempofinal - tempoinicial;
		System.out.println("Tempo de processamento QuickSort por óbito: " + tempototal + "ms");
				
		armazena.Write(path_Quick_Deaths, armazena.getData());
		        
		tempoinicial2 = new Date().getTime();
		
		sort.quickConfirmed(armazena.getData(), 0, armazena.getData().length - 1);
		
		tempofinal2 = new Date().getTime();
		tempototal2 = tempofinal2 - tempoinicial2;
		System.out.println("Tempo de processamento QuickSort por casos confirmados: " + tempototal2 + "ms");	
		        
		armazena.Write(path_Quick_Confirmeds, armazena.getData());
		        
		tempoinicial3 = new Date().getTime();
		
		sort.quickCity(armazena.getData(), 0, armazena.getData().length - 1);
		
		tempofinal3 = new Date().getTime();
		tempototal3 = tempofinal3 - tempoinicial3;
		System.out.println("Tempo de processamento QuickSort por cidades: " + tempototal3 + "ms");
				
		armazena.Write(path_Quick_City, armazena.getData());
						
		System.out.println("QuickSort ordenado \n");
		
		
		// Criando trajeto dos arquivos para ordenar
		
		// QuickSortMed3
		String path_QuickMed3_Deaths = pathDadosTotal + "\\src\\dados\\QuickSortMed3_ordena_obitos.csv";
		String path_QuickMed3_Confirmeds = pathDadosTotal + "\\src\\dados\\QuickSortMed3_ordena_confirmados.csv";
		String path_QuickMed3_City = pathDadosTotal + "\\src\\dados\\QuickSortMed3_ordena_cidades.csv";
								
								
		// Ordanação QuickSortMed3
								
		armazena.Read(path_Arquivo_Dados_Limpos);
				
		tempoinicial = new Date().getTime();
		
		sort.quickDeaths(armazena.getData(), 0, armazena.getData().length - 1);
				
		tempofinal = new Date().getTime();
		tempototal = tempofinal - tempoinicial;
		System.out.println("Tempo de processamento QuickSortMed3 por óbito: " + tempototal + "ms");
				
		armazena.Write(path_QuickMed3_Deaths, armazena.getData());
		        
		tempoinicial2 = new Date().getTime();
		
		sort.quickMed3Confirmeds(armazena.getData(), 0, armazena.getData().length - 1);
		
		tempofinal2 = new Date().getTime();
		tempototal2 = tempofinal2 - tempoinicial2;
		System.out.println("Tempo de processamento QuickSortMed3 por casos confirmados: " + tempototal2 + "ms");	
		        
		armazena.Write(path_QuickMed3_Confirmeds, armazena.getData());
		        
		tempoinicial3 = new Date().getTime();
		
		sort.quickMed3City(armazena.getData(), 0, armazena.getData().length - 1);
		
		tempofinal3 = new Date().getTime();
		tempototal3 = tempofinal3 - tempoinicial3;
		System.out.println("Tempo de processamento QuickSortMed3 por cidades: " + tempototal3 + "ms");
				
		armazena.Write(path_QuickMed3_City, armazena.getData());
						
		System.out.println("QuickSortMed3 ordenado \n");
		
		
		// Criando trajeto dos arquivos para ordenar
		
		// Couting
		String path_Couting_Deaths = pathDadosTotal + "\\src\\dados\\Couting_ordena_obitos.csv";
		String path_Couting_Confirmeds = pathDadosTotal + "\\src\\dados\\Couting_ordena_confirmados.csv";
								
								
		// Ordanação Couting
								
		armazena.Read(path_Arquivo_Dados_Limpos);
				
		tempoinicial = new Date().getTime();
		
		sort.coutingDeaths(armazena.getData());
				
		tempofinal = new Date().getTime();
		tempototal = tempofinal - tempoinicial;
		System.out.println("Tempo de processamento Couting por óbito: " + tempototal + "ms");
				
		armazena.Write(path_Couting_Deaths, armazena.getData());
		        
		tempoinicial2 = new Date().getTime();
		
		sort.coutingConfirmed(armazena.getData());
		
		tempofinal2 = new Date().getTime();
		tempototal2 = tempofinal2 - tempoinicial2;
		System.out.println("Tempo de processamento Couting por casos confirmados: " + tempototal2 + "ms");	
		        
		armazena.Write(path_Couting_Confirmeds, armazena.getData());
		  
		System.out.println("Couting ordenado \n");
		
		
		// Criando trajeto dos arquivos para ordenar
		
		// Heap
		String path_Heap_Deaths = pathDadosTotal + "\\src\\dados\\Heap_ordena_obitos.csv";
		String path_Heap_Confirmeds = pathDadosTotal + "\\src\\dados\\Heap_ordena_confirmados.csv";
		String path_Heap_City = pathDadosTotal + "\\src\\dados\\Heap_ordena_cidades.csv";
								
								
		// Ordanação Heap
								
		armazena.Read(path_Arquivo_Dados_Limpos);
				
		tempoinicial = new Date().getTime();
		
		sort.heapDeaths(armazena.getData());
		tempofinal = new Date().getTime();
		tempototal = tempofinal - tempoinicial;
		System.out.println("Tempo de processamento Heap por óbito: " + tempototal + "ms");
		
		armazena.Write(path_Heap_Deaths, armazena.getData());
		       
		tempoinicial2 = new Date().getTime();
		
		sort.heapConfirmed(armazena.getData());        
		tempofinal2 = new Date().getTime();
		tempototal2 = tempofinal2 - tempoinicial2;
		System.out.println("Tempo de processamento Heap por casos confirmados: " + tempototal2 + "ms");
		
		armazena.Write(path_Heap_Confirmeds, armazena.getData());
		
		tempoinicial3 = new Date().getTime();
		
		sort.heapCity(armazena.getData());	
		tempofinal3 = new Date().getTime();
		tempototal3 = tempofinal3 - tempoinicial3;
		System.out.println("Tempo de processamento Heap por cidades: " + tempototal3 + "ms");
		
		armazena.Write(path_Heap_City, armazena.getData());
						
		System.out.println("Heap ordenado \n");
		
	}

}
