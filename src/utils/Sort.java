package utils;

import java.util.Date;

public class Sort {
	
	public void insertionDeaths(Data_covid[] data) {
		long tempoinicial = new Date().getTime();
        int j;
        int size = data.length;
        
        Data_covid key;

        for(int i = 1; i < size; i++) {
            key = data[i];
            j = i - 1;
            while(j >= 0 && data[j].getDeaths() > key.getDeaths()){
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
        
        long tempofinal = new Date().getTime();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de processamento InsertionSort por óbito: " + tempototal + "ms");
	}
	
	public void insertionConfirmed(Data_covid[] data) {
		long tempoinicial = new Date().getTime();
        Data_covid key;
        int j, size = data.length;

        for(int i = 1; i < size; i++) {
            key = data[i];
            j = i - 1;
            while(j >= 0 && data[j].getConfirmed() > key.getConfirmed()){
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
        
        long tempofinal = new Date().getTime();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de processamento InsertionSort por casos confirmados: " + tempototal + "ms");
    }
	
	public void insertionCity(Data_covid[] data) {
		long tempoinicial = new Date().getTime();
        Data_covid key;
        int j, size = data.length;

        for(int i = 1; i < size; i++) {
            key = data[i];
            j = i - 1;
            while(j >= 0 && data[j].getCity().compareTo(key.getCity()) > 0){
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
        
        long tempofinal = new Date().getTime();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de processamento InsertionSort por cidades: " + tempototal + "ms");
    }
	
	
	public void swap(Data_covid[] data, int i, int j){
        Data_covid temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
	
	public void selectionDeaths(Data_covid[] data) {
		long tempoinicial = new Date().getTime();
        int min;
        int size = data.length;
        
        for(int i = 0; i < size - 1; i++) {
            min = i;
            for(int j = i + 1; j < size; j++) {
                if(data[j].getDeaths() < data[min].getDeaths()) {
                    min = j;
                }
            }
            if(i != min) {
            	swap(data, i, min);
            }
        }
        long tempofinal = new Date().getTime();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de processamento SelectionSort por óbito: " + tempototal + "ms");
    }
	
	public void selectionConfirmed(Data_covid[] data) {
		long tempoinicial = new Date().getTime();
        int min;
        int size = data.length;

        for(int i = 0; i < size - 1; i++) {
            min = i;
            for(int j = i + 1; j < size; j++) {
                if(data[j].getConfirmed() < data[min].getConfirmed()){
                    min = j;
                }
            }
            if(i != min) {
                swap(data, i, min);
            }
        }
        long tempofinal = new Date().getTime();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de processamento SelectionSort por casos confirmados: " + tempototal + "ms");
    }
	
	public void selectionCity(Data_covid[] data) {
		long tempoinicial = new Date().getTime();
        int min;
        int size = data.length;

        for(int i = 0; i < size - 1; i++) {
            min = i;
            for(int j = i + 1; j < size; j++) {
                if(data[j].getCity().compareTo(data[min].getCity()) < 0){
                    min = j;
                }
            }
            if(i != min) {
                swap(data, i, min);
            }
        }
        long tempofinal = new Date().getTime();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de processamento SelectionSort por cidades: " + tempototal + "ms");
    }
	
	
	public void merge(Data_covid[] data, Integer left, Integer mid, Integer right, String comeFrom) {
        int sizeArray1 = mid - left + 1;
        int sizeArray2 = right - mid;

        Data_covid L[] = new Data_covid[sizeArray1];
        Data_covid R[] = new Data_covid[sizeArray2];

        for(int i = 0; i < sizeArray1; i++) {
            L[i] = data[left + i];
        }
        for(int j = 0; j < sizeArray2; j++) {
            R[j] = data[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;

        if(comeFrom.equals("Death")){
            while(i < sizeArray1 && j < sizeArray2) {
                if(L[i].getDeaths() <= R[j].getDeaths()) {
                    data[k] = L[i];
                    i++;
                } else {
                    data[k] = R[j];
                    j++;
                }
                k++;
            }
        } else if(comeFrom.equals("Confirmed")) {
            while(i < sizeArray1 && j < sizeArray2) {
                if(L[i].getConfirmed() <= R[j].getConfirmed()) {
                    data[k] = L[i];
                    i++;
                } else {
                    data[k] = R[j];
                    j++;
                }
                k++;
            }
        } else if(comeFrom.equals("City")){
            while(i < sizeArray1 && j < sizeArray2) {
                if(L[i].getCity().compareTo(R[j].getCity()) <= 0 ) {
                    data[k] = L[i];
                    i++;
                } else {
                    data[k] = R[j];
                    j++;
                }
                k++;
            }
        }

        while(i < sizeArray1) {
            data[k] = L[i];
            i++;
            k++;
        }
        while (j < sizeArray2) {
            data[k] = R[j];
            j++;
            k++;
        }
    }

    public void mergeDeaths(Data_covid[] data, Integer left, Integer right) {
    	
        if(left < right) {
            int mid = left + (right-left) / 2;

            mergeDeaths(data, left, mid);
            mergeDeaths(data, mid + 1, right);
            merge(data, left, mid, right, "Death");
        }
        
    }

    public void mergeConfirmed(Data_covid[] data, Integer left, Integer right) {
    	
        if(left < right) {
            int mid = left + (right-left) / 2;

            mergeConfirmed(data, left, mid);
            mergeConfirmed(data, mid + 1, right);
            merge(data, left, mid, right, "Confirmed");
        }
       
    }

    public void mergeCity(Data_covid[] data, Integer left, Integer right) {
    	
        if(left < right) {
            int mid = left + (right-left) / 2;

            mergeCity(data, left, mid);
            mergeCity(data, mid + 1, right);
            merge(data, left, mid, right, "City");
        }
        
    }

    
    public static int partitionForQuickSort(Data_covid data[], int inicio, int fim, String comeFrom) {
        Data_covid pivot = data[fim];
        int i = (inicio - 1);

        if(comeFrom.equals("Death")) {
            for (int j = inicio; j < fim; j++) {
                if (data[j].getDeaths() <= pivot.getDeaths()) {
                    i++;

                    Data_covid temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        } else if(comeFrom.equals("Confirmed")) {
            for (int j = inicio; j < fim; j++) {
                if (data[j].getConfirmed() <= pivot.getConfirmed()) {
                    i++;

                    Data_covid temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        } else if(comeFrom.equals("City")) {
            for (int j = inicio; j < fim; j++) {
                if (data[j].getCity().compareTo(pivot.getCity()) <= 0) {
                    i++;

                    Data_covid temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }

        Data_covid temp = data[i + 1];
        data[i + 1] = data[fim];
        data[fim] = temp;

        return i + 1;
    }

    public void quickDeaths(Data_covid data[], int inicio, int fim) {
        if (inicio < fim) {
            int partitionIndex = partitionForQuickSort(data, inicio, fim, "Death");

            quickDeaths(data, inicio, partitionIndex - 1);
            quickDeaths(data, partitionIndex + 1, fim);
        }
    }

    public void quickConfirmed(Data_covid data[], int inicio, int fim) {
        if (inicio < fim) {
            int partitionIndex = partitionForQuickSort(data, inicio, fim, "Confirmed");

            quickConfirmed(data, inicio, partitionIndex - 1);
            quickConfirmed(data, partitionIndex + 1, fim);
        }
    }

    public void quickCity(Data_covid data[], int inicio, int fim) {
        if (inicio < fim) {
            int partitionIndex = partitionForQuickSort(data, inicio, fim, "City");

            quickCity(data, inicio, partitionIndex - 1);
            quickCity(data, partitionIndex + 1, fim);
        }
    }
    
    
    private static void swapMedianaDeTres(Data_covid data[], int i, int j) {
        Data_covid temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static int partitionQuickMedianaDeTres(Data_covid data[], int inicio, int fim, String comeFrom) {
        int meio = (inicio + fim) / 2;
        Data_covid a = data[inicio];
        Data_covid b = data[meio];
        Data_covid c = data[fim];

        int medianaIndice;

        if(comeFrom == "Death") {
            if (a.getDeaths() < b.getDeaths()) {
                if (b.getDeaths() < c.getDeaths()) {
                    //a < b && b < c
                    medianaIndice = meio;
                } else {
                    if (a.getDeaths() < c.getDeaths()) {
                        //a < c && c <= b
                        medianaIndice = fim;
                    } else {
                        //c <= a && a < b
                        medianaIndice = inicio;
                    }
                }
            } else {
                if (c.getDeaths() < b.getDeaths()) {
                    //c < b && b <= a
                    medianaIndice = meio;
                } else {
                    if (c.getDeaths() < a.getDeaths()) {
                        //b <= c && c < a
                        medianaIndice = fim;
                    } else {
                        //b <= a && a <= c
                        medianaIndice = inicio;
                    }
                }
            }
            swapMedianaDeTres(data, medianaIndice, fim);
            Data_covid pivo = data[fim];
            int i = inicio - 1;

            for (int j = inicio; j <= fim - 1; j++) {
                if (data[j].getDeaths() <= pivo.getDeaths()) {
                    i = i + 1;
                    swapMedianaDeTres(data, i, j);
                }
            }
            swapMedianaDeTres(data, i + 1, fim);
            return i + 1;
        } else if(comeFrom == "Confirmed") {
            if (a.getConfirmed() < b.getConfirmed()) {
                if (b.getConfirmed() < c.getConfirmed()) {
                    //a < b && b < c
                    medianaIndice = meio;
                } else {
                    if (a.getConfirmed() < c.getConfirmed()) {
                        //a < c && c <= b
                        medianaIndice = fim;
                    } else {
                        //c <= a && a < b
                        medianaIndice = inicio;
                    }
                }
            } else {
                if (c.getConfirmed() < b.getConfirmed()) {
                    //c < b && b <= a
                    medianaIndice = meio;
                } else {
                    if (c.getConfirmed() < a.getConfirmed()) {
                        //b <= c && c < a
                        medianaIndice = fim;
                    } else {
                        //b <= a && a <= c
                        medianaIndice = inicio;
                    }
                }
            }
            swapMedianaDeTres(data, medianaIndice, fim);
            Data_covid pivo = data[fim];
            int i = inicio - 1;

            for (int j = inicio; j <= fim - 1; j++) {
                if (data[j].getConfirmed() <= pivo.getConfirmed()) {
                    i = i + 1;
                    swapMedianaDeTres(data, i, j);
                }
            }
            swapMedianaDeTres(data, i + 1, fim);
            return i + 1;
        } else {
            if (a.getCity().compareTo(b.getCity()) < 0) {
                if (b.getCity().compareTo(c.getCity()) < 0) {
                    //a < b && b < c
                    medianaIndice = meio;
                } else {
                    if (a.getCity().compareTo(c.getCity()) < 0) {
                        //a < c && c <= b
                        medianaIndice = fim;
                    } else {
                        //c <= a && a < b
                        medianaIndice = inicio;
                    }
                }
            } else {
                if (c.getCity().compareTo(b.getCity()) < 0) {
                    //c < b && b <= a
                    medianaIndice = meio;
                } else {
                    if (c.getCity().compareTo(a.getCity()) < 0) {
                        //b <= c && c < a
                        medianaIndice = fim;
                    } else {
                        //b <= a && a <= c
                        medianaIndice = inicio;
                    }
                }
            }
            swapMedianaDeTres(data, medianaIndice, fim);
            Data_covid pivo = data[fim];
            int i = inicio - 1;

            for (int j = inicio; j <= fim - 1; j++) {
                if (data[j].getCity().compareTo(pivo.getCity()) <= 0) {
                    i = i + 1;
                    swapMedianaDeTres(data, i, j);
                }
            }
            swapMedianaDeTres(data, i + 1, fim);
            return i + 1;
        }
    }

    public void quickMed3Deaths(Data_covid[] data, int inicio, int fim) {
        if (inicio < fim) {
            int q = partitionQuickMedianaDeTres(data, inicio, fim, "Death");
            quickMed3Deaths(data, inicio, q - 1);
            quickMed3Deaths(data, q + 1, fim);
        }
    }

    public void quickMed3Confirmeds(Data_covid[] data, int inicio, int fim) {
        if (inicio < fim) {
            int q = partitionQuickMedianaDeTres(data, inicio, fim, "Confirmed");
            quickMed3Confirmeds(data, inicio, q - 1);
            quickMed3Confirmeds(data, q + 1, fim);
        }
    }

    public void quickMed3City(Data_covid[] data, int inicio, int fim) {
        if (inicio < fim) {
            int q = partitionQuickMedianaDeTres(data, inicio, fim, "City");
            quickMed3City(data, inicio, q - 1);
            quickMed3City(data, q + 1, fim);
        }
    }
    
    
    public int[] maxValueCountingSort(Data_covid data[], String comeFrom) {
        int size = data.length;
        int maxValue;
        int minValue;

        if(comeFrom.equals("Death")) {
            maxValue = data[0].getDeaths();
            minValue = data[0].getDeaths();
            for (int i = 0; i < size; i++) {
                if(data[i] != null) {
                    if (maxValue < data[i].getDeaths()) {
                        maxValue = data[i].getDeaths();
                    }
                    if (minValue > data[i].getDeaths()) {
                        minValue = data[i].getDeaths();
                    }
                }
            }
            int max_Min_values[] = {maxValue, minValue};
            return max_Min_values;
        } else {
            maxValue = data[0].getConfirmed();
            minValue = data[0].getDeaths();
            for (int i = 0; i < size; i++) {
                if(data[i] != null) {
                    if (maxValue < data[i].getConfirmed()) {
                        maxValue = data[i].getConfirmed();
                    }
                    if (minValue > data[i].getConfirmed()) {
                        minValue = data[i].getConfirmed();
                    }
                }
            }
            int max_Min_values[] = {maxValue, minValue};
            return max_Min_values;
        }
    }

    public void coutingDeaths(Data_covid data[]) {
        int Values[] = maxValueCountingSort(data, "Death");
        int maxValue = Values[0];
        int minValue = Values[1];
        int range = maxValue - minValue + 1;
        int count[] = new int[range];
        Data_covid finishSort[] =  new Data_covid[data.length];

        for(int i = 1; i < data.length; i++) {
            count[data[i].getDeaths() - minValue]++;
        }

        for(int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for(int i = data.length - 1; i >= 0; i--) {
            finishSort[count[data[i].getDeaths()] - 1] = data[i];
            count[data[i].getDeaths() - minValue]--;
        }

        for(int i = 0; i < data.length; i++) {
            data[i] = finishSort[i];
        }
    }

    public void coutingConfirmed(Data_covid data[]) {
        int Values[] = maxValueCountingSort(data, "Confirmed");
        int maxValue = Values[0];
        int minValue = Values[1];
        int range = maxValue - minValue + 1;
        int count[] = new int[range];
        Data_covid finishSort[] =  new Data_covid[data.length];

        for(int i = 1; i < data.length; i++) {
            if(data[i] != null) {
                count[data[i].getConfirmed() - minValue]++;
            }
        }

        for(int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for(int i = data.length - 1; i >= 0; i--) {
            if(data[i] != null) {
                finishSort[count[data[i].getConfirmed()] - 1] = data[i];
                count[data[i].getConfirmed() - minValue]--;
            }
        }

        for(int i = 0; i < data.length; i++) {
            data[i] = finishSort[i];
        }
    }
    
    
    public void heapDeaths(Data_covid data[]) {
        int tamanho = data.length;
        int i = tamanho / 2, pai, filho;
        Data_covid t;
        while (true){
            if (i > 0){
                i--;
                t = data[i];
            }else{
                tamanho--;
                if (tamanho <= 0) {return;}
                t = data[tamanho];
                data[tamanho] = data[0];
            }
            pai = i;
            filho = ((i * 2) + 1);
            while (filho < tamanho){
                if ((filho + 1 < tamanho) && (data[filho + 1].getDeaths() > data[filho].getDeaths())) {filho++;}
                if (data[filho].getDeaths() > t.getDeaths()){
                    data[pai] = data[filho];
                    pai = filho;
                    filho = pai * 2 + 1;
                }else {break;}
            }
            data[pai] = t;
        }
       
    }

    public void heapConfirmed(Data_covid data[]) {
    	
        int tamanho = data.length;
        int i = tamanho / 2, pai, filho;
        Data_covid t;
        while (true){
            if (i > 0){
                i--;
                t = data[i];
            }else{
                tamanho--;
                if (tamanho <= 0) {return;}
                t = data[tamanho];
                data[tamanho] = data[0];
            }
            pai = i;
            filho = ((i * 2) + 1);
            while (filho < tamanho){
                if ((filho + 1 < tamanho) && (data[filho + 1].getConfirmed() > data[filho].getConfirmed())) {filho++;}
                if (data[filho].getConfirmed() > t.getConfirmed()){
                    data[pai] = data[filho];
                    pai = filho;
                    filho = pai * 2 + 1;
                }else {break;}
            }
            data[pai] = t;
        }
        
    }

    public void heapCity(Data_covid data[]) {
    	
        int tamanho = data.length;
        int i = tamanho / 2, pai, filho;
        Data_covid t;
        while (true){
            if (i > 0){
                i--;
                t = data[i];
            }else{
                tamanho--;
                if (tamanho <= 0) {return;}
                t = data[tamanho];
                data[tamanho] = data[0];
            }
            pai = i;
            filho = ((i * 2) + 1);
            while (filho < tamanho){
                if ((filho + 1 < tamanho) && (data[filho + 1].getCity().compareTo(data[filho].getCity())) > 0) {filho++;}
                if (data[filho].getCity().compareTo(t.getCity()) > 0){
                    data[pai] = data[filho];
                    pai = filho;
                    filho = pai * 2 + 1;
                }else {break;}
            }
            data[pai] = t;
        }
        
    }
    
}
