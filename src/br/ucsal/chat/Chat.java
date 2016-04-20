package br.ucsal.chat;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Chat {
	
	Map<String,StringBuilder> canal = new TreeMap<>();
		
	public StringBuilder getCanal(String usuario) {
		return canal.get(usuario);
	}

	public void addUsuario(String usuario) {
		this.canal.put(usuario, new StringBuilder());
	}
	
	public Set<String> getUsuarios() {
		return canal.keySet();
	}

	public void enviaMensagem(String from, String to ,String texto){
		if(to.equals("TODOS")){
			for (StringBuilder sb : canal.values()) {
				sb.append(from+": "+ texto+"\n");
			}
		}else{
			canal.get(from).append(from+": "+ texto+"\n");
			canal.get(to).append(from+": "+ texto+"\n");
		}

	}
	
}
