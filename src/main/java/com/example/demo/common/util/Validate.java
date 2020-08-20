package com.example.demo.common.util;

import java.util.regex.Pattern;

import com.example.demo.common.ErrorResponseBodies;
import com.example.demo.morningpanic.entities.*;
import com.example.demo.morningpanic.models.Envelope;
import com.example.demo.common.models.Response;

import static com.example.demo.common.ErrorResponseBodies.get;
import static com.example.demo.webscraper.util.Validate.validateJavaDate;
import static com.example.demo.webscraper.util.Validate.validateSymbol;

public class Validate {

    public static boolean isTime(String str) {
        return Pattern.matches("[0-2][0-3]:[0-5][0-9]", str) || Pattern.matches("[0][0-9]:[0-9][0-9]", str)
                || Pattern.matches("[0-9]:[0-9][0-9]", str);
    }

    public static Response validate_MorningPanicEnvelope(Envelope envelope){
        //System.out.println(envelope.data.toString());
        boolean valid = true;
        String response = "";
        if(!validateSymbol(envelope.data.symbol)){ response = get(ErrorResponseBodies.invalid_data_symbol); valid = false; }
        if(envelope.history_length < 0 || envelope.history_length > 100){ response = get(ErrorResponseBodies.invalid_history_length); valid = false; }
        if(!validateJavaDate(envelope.date)){ response = get(ErrorResponseBodies.invalid_date); valid = false; }

        // DATA
        if(envelope.data.panic_bounce.drop.price < 0){ response = get(ErrorResponseBodies.invalid_data_panic_bounce_drop_price); valid = false; }
        if(!isTime(envelope.data.panic_bounce.drop.time)){ response = get(ErrorResponseBodies.invalid_data_panic_bounce_drop_time); valid = false; }
        if(envelope.data.panic_bounce.bottom.price < 0){ response = get(ErrorResponseBodies.invalid_data_panic_bounce_bottom_price); valid = false; }
        if(!isTime(envelope.data.panic_bounce.bottom.time)){ response = get(ErrorResponseBodies.invalid_data_panic_bounce_bottom_time); valid = false; }
        if(envelope.data.panic_bounce.top.price < 0){ response = get(ErrorResponseBodies.invalid_data_panic_bounce_top_price); valid = false; }
        if(!isTime(envelope.data.panic_bounce.top.time)){ response = get(ErrorResponseBodies.invalid_data_panic_bounce_top_time); valid = false; }
        if(envelope.data.premarket.high.price < 0){ response = get(ErrorResponseBodies.invalid_data_premarket_high_price); valid = false; }
        if(!isTime(envelope.data.premarket.high.time)){ response = get(ErrorResponseBodies.invalid_data_premarket_high_time); valid = false; }
        if(envelope.data.premarket.low_after_high.price < 0){ response = get(ErrorResponseBodies.invalid_data_premarket_low_after_high_price); valid = false; }
        if(!isTime(envelope.data.premarket.low_after_high.time)){ response = get(ErrorResponseBodies.invalid_data_premarket_low_after_high_time); valid = false; }

        // KEY LEVELS
        for(KeyLevelEntity keyLevel : envelope.key_levels){
            if(!KeyLevelEntity.validate_type(keyLevel.type)){ response = get(ErrorResponseBodies.invalid_key_levels_type); valid = false; }
            if(keyLevel.price < 0){ response = get(ErrorResponseBodies.invalid_key_levels_price); valid = false; }
        }

        // TECHNICAL INDICATOR BEHAVIOR
        for(TechnicalIndicatorBehaviorEntity technicalIndicator : envelope.technical_indicator_behaviors){
            if(!TechnicalIndicatorBehaviorEntity.validate_type(technicalIndicator.type)){ response = get(ErrorResponseBodies.invalid_technical_indicator_behaviors_type); valid = false; }
            if(!isTime(technicalIndicator.time)){ response = get(ErrorResponseBodies.invalid_technical_indicator_behaviors_time); valid = false; }
            if(technicalIndicator.price < 0){ response = get(ErrorResponseBodies.invalid_technical_indicator_behaviors_price); valid = false; }
        }

        // FAILED BOUNCES
        for(FailedBounceEntity failedBounce : envelope.failed_bounces){
            if(failedBounce.drop.price < 0){ response = get(ErrorResponseBodies.invalid_failed_bounces_drop_price); valid = false; }
            if(!isTime(failedBounce.drop.time)){ response = get(ErrorResponseBodies.invalid_failed_bounces_drop_time); valid = false; }
            if(failedBounce.bottom.price < 0){ response = get(ErrorResponseBodies.invalid_failed_bounces_bottom_price); valid = false; }
            if(!isTime(failedBounce.bottom.time)){ response = get(ErrorResponseBodies.invalid_failed_bounces_bottom_time); valid = false; }
            if(failedBounce.top.price < 0){ response = get(ErrorResponseBodies.invalid_failed_bounces_top_price); valid = false; }
            if(!isTime(failedBounce.top.time)){ response = get(ErrorResponseBodies.invalid_failed_bounces_top_time); valid = false; }
        }

        // PULLBACK BOUNCES
        for(PullbackBounceEntity pullBackBounce : envelope.pullback_bounces){
            if(pullBackBounce.drop.price <0){ response = get(ErrorResponseBodies.invalid_pullback_bounces_drop_price); valid = false; }
            if(!isTime(pullBackBounce.drop.time)){ response = get(ErrorResponseBodies.invalid_pullback_bounces_drop_time); valid = false; }
            if(pullBackBounce.bottom.price <0){ response = get(ErrorResponseBodies.invalid_pullback_bounces_bottom_price); valid = false; }
            if(!isTime(pullBackBounce.bottom.time)){ response = get(ErrorResponseBodies.invalid_pullback_bounces_bottom_time); valid = false; }
            if(pullBackBounce.top.price <0){ response = get(ErrorResponseBodies.invalid_pullback_bounces_top_price); valid = false; }
            if(!isTime(pullBackBounce.top.time)){ response = get(ErrorResponseBodies.invalid_pullback_bounces_top_time); valid = false; }
        }


        // FAILED MORNING SPIKES
        for(FailedMorningSpikeEntity morningSpike : envelope.failed_morning_spikes){
            if(morningSpike.start.price < 0){ response = get(ErrorResponseBodies.invalid_failed_morning_spikes_start_price); valid = false; }
            if(!isTime(morningSpike.start.time)){ response = get(ErrorResponseBodies.invalid_failed_morning_spikes_start_time); valid = false; }
            if(morningSpike.top.price < 0){ response = get(ErrorResponseBodies.invalid_failed_morning_spikes_top_price); valid = false; }
            if(!isTime(morningSpike.top.time)){ response = get(ErrorResponseBodies.invalid_failed_morning_spikes_top_time); valid = false; }
            if(morningSpike.bottom.price < 0){ response = get(ErrorResponseBodies.invalid_failed_morning_spikes_bottom_price); valid = false; }
            if(!isTime(morningSpike.bottom.time)){ response = get(ErrorResponseBodies.invalid_failed_morning_spikes_bottom_time); valid = false; }
        }


        // CATALYSTS
        for(CatalystEntity catalyst : envelope.catalysts){
            if(!validateJavaDate(catalyst.date)){ response = get(ErrorResponseBodies.invalid_catalyst_date); valid = false; }
            if(!isTime(catalyst.time)){ response = get(ErrorResponseBodies.invalid_catalyst_time); valid = false; }
            int description_size = catalyst.description.length();
            System.out.println("Description size: " + description_size);
            if(description_size == 0 || description_size > 1000000){ response = get(ErrorResponseBodies.invalid_catalyst_description); valid = false; }
        }



        return new Response(valid, response);
    }

}
