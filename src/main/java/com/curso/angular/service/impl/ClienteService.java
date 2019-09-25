package com.curso.angular.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Service;

import com.curso.angular.base.service.ServiceCrudAbstractImpl;
import com.curso.angular.entity.Cliente;
import com.curso.angular.service.interfaces.IClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService extends ServiceCrudAbstractImpl<Cliente, Integer> implements IClienteService {

	@Override
	public String buscarCep(String cep) {
		String json;

		try {
			URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			StringBuilder jsonSb = new StringBuilder();

			br.lines().forEach(l -> jsonSb.append(l.trim()));

			json = jsonSb.toString();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return json;
	}
}
