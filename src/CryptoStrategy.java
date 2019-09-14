// Abstract strategy
interface CryptoAlgorithm {

    char[] crypt(char[] data, int key);
}

// Context class in Strategy
class Cryptor {
    private CryptoAlgorithm algorithm;

    void setAlgorithm(CryptoAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    String crypt(String data, int key) {
        return String.valueOf(algorithm.crypt(data.toCharArray(), key));
    }
}

//Concrete strategies

class UnicodeEncryption implements CryptoAlgorithm {

    @Override
    public char[] crypt(char[] data, int key) {
        for (var i = 0; i < data.length; i++) data[i] += key;
        return data;
    }
}

class UnicodeDecryption implements CryptoAlgorithm {

    @Override
    public char[] crypt(char[] data, int key) {
        for (var i = 0; i < data.length; i++) data[i] -= key;
        return data;
    }
}

class ShiftingEncryption implements CryptoAlgorithm {

    @Override
    public char[] crypt(char[] data, int key) {
        for (var i = 0; i < data.length; i++)
            if (data[i] >= 'a' && data[i] <= 'z') data[i] += (('z' - data[i]) >= key) ? key : (key - (('z' - 'a') + 1));
        return data;
    }
}

class ShiftingDecryption implements CryptoAlgorithm {

    @Override
    public char[] crypt(char[] data, int key) {
        for (var i = 0; i < data.length; i++)
            if (data[i] >= 'a' && data[i] <= 'z') data[i] -= ((data[i] - 'a') >= key) ? key : (key - (('z' - 'a') + 1));
        return data;
    }
}
