package org.dragon.algorithm.rsync;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.java.Adler32.Adler32;

import MD5.MD5;

public class Rsync {
	
	public static Map<Integer,List<Chunk>>calcCheckSum(String fileName){
		Map<Integer,List<Chunk>> checkSums = new HashMap<Integer,List<Chunk>>();
		
		File file = new File(fileName);
		if(!file.exists()){
			return null;
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			
		//	long length = file.length();
			byte[] buffer = new byte[Constant.CHUNK_SIZE];
			int read = 0;
			int index = 0;
			try {
				while((read = fis.read(buffer))!= -1){
					Chunk chunk = new Chunk();
					chunk.setIndex(index);
					index++;
					chunk.setSize(read);//����chunk�Ĵ�С
					
					int weakCheckSum = calaWeakCheckSum(buffer,read);//�����������
					String strongCheckSum = calacSttrongCheckSum(buffer,read);//����ǿУ���
					chunk.setWeakCheckSum(weakCheckSum);
					chunk.setStrongCheckSum(strongCheckSum);
					
					//���checkSums�����д���У��ͣ���ô������ȡ�������µ�chunk��������
					if(checkSums.containsKey(weakCheckSum)){
						List<Chunk> chunks = checkSums.get(weakCheckSum);
						chunks.add(chunk);
					}else{
						List<Chunk> chunks = new ArrayList<Chunk>();
						chunks.add(chunk);
						checkSums.put(weakCheckSum, chunks);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return checkSums;
	}
	
	//�������ݵ�Alder32
	private static int calaWeakCheckSum(byte[] datas, int size){
		byte[] temp = new byte[size];
		for(int i = 0; i < size; i++){
			temp[i] = datas[i];
		}
		return Adler32.adler32(temp);
	}
	
	private static String calacSttrongCheckSum(byte[] datas, int size){
		byte[] temp = new byte[size];
		for(int i = 0; i < size; i++){
			temp[i] = datas[i];
		}
		return MD5.getMD5(temp);
		
	}
	
}


