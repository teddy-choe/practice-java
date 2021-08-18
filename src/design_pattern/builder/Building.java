package design_pattern.builder;

class Building {
    private final int buildingId;
    private final int floor;
    private final int livingNum;

    public static class Builder {
        private final int buildingId;

        private int floor = 0;
        private int livingNum = 0;

        public Builder(int buildingId) {
            this.buildingId = buildingId;
        }

        public Builder floor(int val) {
            floor = val;
            return this;
        }

        public Builder livingNum(int val) {
            livingNum = val;
            return this;
        }

        public Building build() {
            return new Building(this);
        }
    }

    private Building(Builder builder) {
        buildingId = builder.buildingId;
        floor = builder.floor;
        livingNum = builder.livingNum;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public int getFloor() {
        return floor;
    }

    public int getLivingNum() {
        return livingNum;
    }
}
