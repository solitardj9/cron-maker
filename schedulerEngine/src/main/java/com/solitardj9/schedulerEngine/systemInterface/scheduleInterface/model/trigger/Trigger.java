package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.trigger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use= JsonTypeInfo.Id.NAME,
        //include = JsonTypeInfo.As.PROPERTY,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
    @Type(value = EventTimeTrigger.class, name = "time"),
    @Type(value = EventStateTrigger.class, name = "state"),
    @Type(value = DataTrigger.class, name = "data")
})
public class Trigger {
	//
	@JsonProperty(value = "type") private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Trigger [type=" + type + "]";
	}
}