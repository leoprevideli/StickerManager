package br.com.cast.turmaformacao.testecontrole.controller.model.services;

import java.util.List;

import br.com.cast.turmaformacao.testecontrole.controller.model.entities.Sticker;
import br.com.cast.turmaformacao.testecontrole.controller.model.persistence.StickerRepository;

public class StickerBusinessService {

    public StickerBusinessService() {
        super();
    }

    public static List<Sticker> getAll(){
        return StickerRepository.getAll();
    }

    public static void saveSticker(Sticker sticker){
        StickerRepository.saveSticker(sticker);
    }
}
