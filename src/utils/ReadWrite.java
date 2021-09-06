package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWrite {
	
	private static final Integer add_capacity = 10;
    private Data_covid[] data;
    private int size = 0;
    

    public ReadWrite() {
        data = new Data_covid[add_capacity];
    }

    private void moreSize() {
        int newSize = data.length + add_capacity;
        Data_covid temp[] = data;
        data = new Data_covid[newSize];
        for(int i = 0; i < temp.length; i++) {
            data[i] = temp[i];
        }
    }

    private void verifyNull(){
        int verify = 0;
        Data_covid temp[] = data;
        for(int i = 0; i < data.length; i++) {
            if(data[i] == null) {
                verify++;
            }
        }
        data = new Data_covid[temp.length - verify];

        for(int i = 0; i < data.length; i++) {
            data[i] = temp[i];
        }
    }

    public void add(Data_covid newData) {
        if(data.length == size){
            moreSize();
        }
        data[size] = newData;
        size++;
    }
	
	
	public void Read(String path) {
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line != null) {
				
				String[] vector = line.split(",");
				if(vector[7].equals("True") && vector !=null) {
					
					add(new Data_covid(vector[0], vector[1], vector[2], vector[3], Integer.parseInt(vector[4]), Integer.parseInt(vector[5]), vector[6], vector[7], vector[8], vector[9], vector[10], vector[11], vector[12]));
				}
				
				line = br.readLine();
			}
			
			verifyNull();
			
		}
		catch (IOException e){
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	
	public void Write(String path, Data_covid data[]) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line = "";
            bw.write("date, state, city, place_type, confirmed, deaths, order_for_place, is_last, estimated_population_2019, estimated_population, city_ibge_code, confirmed_per_100k_inhabitants, death_rate" + '\n');
            for(int j = 0; j < data.length; j++) {
                if(data != null) {
                   
                    line = data[j].getDate() + ", " + data[j].getState() + ", " + data[j].getCity() + ", " + data[j].getPlace_type() + ", " + data[j].getConfirmed() + ", " + data[j].getDeaths() + ", " + data[j].getOrder_for_place() + ", " + data[j].getIs_last() + ", " + data[j].getEstimated_population_2019() + ", " + data[j].getEstimed_population()+ ", " + data[j].getCity_ibge_code() + ", " + data[j].getConfirmed_per_100k_inhabitants() + ", " + data[j].getDeath_rate();
                    bw.write(line + '\n');
                }
            }
            
        } catch(Exception e) {
            System.out.println("Error = " + e);
        }
		
	}
	
	
	public Data_covid[] getData(){
		return this.data;
	}

}
