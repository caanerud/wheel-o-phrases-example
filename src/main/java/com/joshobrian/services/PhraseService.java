package com.joshobrian.services;

import com.joshobrian.contoller.PhraseRepository;
import com.joshobrian.model.Phrase;

/**
 * Created by josh on 4/6/17.
 */
public class PhraseService {
	private PhraseRepository repository;

	public PhraseService(){
		repository = new PhraseRepository("jdbc:postgresql://localhost:5432/wheelophases");
	}

	public Phrase getPhrase() throws Exception {
		return repository.getPhasesByCategory(2);
	}
}
