package io.sbrreact.ipldashboard.batch;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<MatchInputEntity, MatchOutputEntity> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public MatchOutputEntity process(final MatchInputEntity matchInput) {

        MatchOutputEntity matchOutput = getMatchOutputEntity(matchInput);

        log.info("Converting (" + matchInput + ") into (" + matchOutput + ")");

        return matchOutput;
    }

    private MatchOutputEntity getMatchOutputEntity(MatchInputEntity matchInput) {

        MatchOutputEntity matchOutput = new MatchOutputEntity();

        matchOutput.setId(Long.valueOf(matchInput.getId()));
        matchOutput.setCity(matchInput.getCity());
        matchOutput.setDate(Date.valueOf(matchInput.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        matchOutput.setPlayerOfMatch(matchInput.getPlayer_of_match());
        matchOutput.setVenue(matchInput.getVenue());
        matchOutput.setTeam1(matchInput.getTeam1());
        matchOutput.setTeam2(matchInput.getTeam2());
        matchOutput.setTossDecision(matchInput.getToss_decision());
        matchOutput.setMatchWinner(matchInput.getWinner());
        matchOutput.setResult(matchInput.getResult());
        matchOutput.setResultMargin(matchInput.getResult_margin();
        matchOutput.setUmpire1(matchInput.getUmpire1());
        matchOutput.setUmpire2(matchInput.getUmpire2());
        /*
        Long.valueOf(matchInput.getId()), matchInput.getCity(),
                Date.valueOf(matchInput.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                matchInput.getPlayer_of_match(), matchInput.getVenue(),
                matchInput.getTeam1(), matchInput.getTeam2(), matchInput.getToss_decision(), matchInput.getWinner(),
                matchInput.getResult(), matchInput.getResult_margin(), matchInput.getUmpire1(),
                matchInput.getUmpire2());
        */

        return matchOutput;
    }

}
