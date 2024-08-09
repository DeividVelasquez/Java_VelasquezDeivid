package Builder;

public class carro {
    private String motor;
    private int ruedas;
    private String modelo;

    private carro(Builder builder){
        this.motor = builder.motor;
        this.ruedas = builder.ruedas;
        this.modelo = builder.modelo;
    }

    public static class Builder {
        private String motor;
        private int ruedas;
        private String modelo;

        public Builder setMotor(String motor){
            this.motor = motor;
            return  this;
        }

        public Builder setRuedas(int ruedas){
            this.ruedas = ruedas;
            return this;
        }

        public Builder setModelo(String modelo){
            this.modelo = modelo;
            return this;
        }

        public carro build(){
            return new carro(this);
        }
    }
}
