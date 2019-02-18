package com.example.mentorship.model;

public enum EHairCut {

	TUNS("TUNS") {
		@Override
		public double getDuration() {
			return 2;
		}
	},
	SPALAT("SPALAT") {
		@Override
		public double getDuration() {
			return 0.5;
		}
	},
	FREZA("FREZA") {
		@Override
		public double getDuration() {
			return 1;
		}
	},

	VOPSIT("VOPSIT") {

		@Override
		public double getDuration() {
			return 3;
		}

	};

	private String description;

	EHairCut(String description) {
		this.description = description;
	}

	public String getDesctiption() {
		return description;
	}

	public abstract double getDuration();

}
