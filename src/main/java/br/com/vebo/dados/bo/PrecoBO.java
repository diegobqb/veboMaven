/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.dados.bo;

import br.com.vebo.dados.dto.PrecoDTO;
import br.com.vebo.dados.mapeamento.Calculo;
import br.com.vebo.dados.mapeamento.Configuracao;
import br.com.vebo.dados.mapeamento.Perfume;
import br.com.vebo.dados.mapeamento.UtilizacaoMaterial;

/**
 *
 * @author mohfus
 */
public class PrecoBO {

    public PrecoDTO calcularPreco(Perfume perfume, Calculo calculo) {
        Configuracao configuracao = new ConfiguracaoBO().retrieve();

        PrecoDTO precoDTO = new PrecoDTO();
        precoDTO.setPerfume(perfume);
        precoDTO.setNomeCalculo(calculo.getNome());
        precoDTO.setCusto(perfume.getValorEssencia10ml()*calculo.getUtilizacaoEssencia());
        for (UtilizacaoMaterial utilizacaoMaterial : calculo.getUtilizacoes()) {
            precoDTO.setCusto(precoDTO.getCusto()+(utilizacaoMaterial.getQuantidade()*utilizacaoMaterial.getMaterial().getValor()));
        }
        precoDTO.setCusto(precoDTO.getCusto()*configuracao.getTaxaCusto());
        precoDTO.setValorRevendedor(precoDTO.getCusto()*configuracao.getTaxaValorRevendedor());
        precoDTO.setValorFinal(precoDTO.getValorRevendedor()*configuracao.getTaxaValorFinal());
        precoDTO.setLucroRevendedor(precoDTO.getValorFinal()*configuracao.getTaxaLucroRevendedor());
        return precoDTO;
    }

}
