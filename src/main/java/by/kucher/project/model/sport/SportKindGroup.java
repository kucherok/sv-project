package by.kucher.project.model.sport;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import by.kucher.project.model.common.CommonEntityDict;

public class SportKindGroup extends CommonEntityDict {

	private static final long serialVersionUID = -7405068168624164407L;

	@Enumerated(EnumType.ORDINAL)
	private SportKindCategory sportKindCategory;
	private SportKindGroup sportKindGroup; // связать с группамиы

}
