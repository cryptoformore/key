package codes.foundation.crypto.base;

/**
 * @author cryptoformore
 */
public class BaseTest {

//    protected static final byte[] PUB_KEY_HASH_160 = Hex.decode("28e47186bc1726da45ab3c1116a69af5d62bd517");
//
//    protected static final String LENGTH_INVALID_ADDRESS1 = "14jDhCnfgF5wjwWzxBfjD6PU2vpoy1u6kJlasdfasdf";
//    protected static final String LENGTH_INVALID_ADDRESS2 = "14jDhCnfgF5wjwWzxBfjD6";
//    protected static final String PREFIX_INVALID_ADDRESS = "j4jDhCnfgF5wjwWzxBfjD6PU2vpoy1u6kJ";
//    protected static final String CHECKSUM_INVALID_ADDRESS = "14jDhCnfgF5wjwWzxBfjD6PU2vpoy1u6kJ0";
//
//    protected static final String P2PKH_ADDRESS = "1AWRZiJgw56D8dcH5rQw7RbLAKwq281P1W";
//    protected static final String P2PKH_TEST_ADDRESS = "mq2NrmPfk6XTuk5toRPJwLof2KYXy8AcQ2";
//
//    protected static final String P2SH_ADDRESS = "3BCSVFo8UyQbDoJiCx5XY3xGJrEYXZe2ho";
//    protected static final String P2SH_TEST_ADDRESS = "2N2keYzjA6RuwRawFt5hQ9zwXXCSiJLNjNf";
//
//    protected static final byte[] PRI_KEY_DUMMY_32 = Hex.decode("ef235aacf90d9f4aadd8c92e4b2562e1d9eb97f0df9ba3b508258739cb013db2");
//
//    protected static final String WIF_COMPRESSED = "L5EZftvrYaSudiozVRzTqLcHLNDoVn7H5HSfM9BAN6tMJX8oTWz6";
//    protected static final String WIF_TEST_COMPRESSED = "cVbZ8ovhye9AoAHFsqobCf7LxbXDAECy9Kb8TZdfsDYMZGBUyCnm";
//
//    protected static final String WIF_UNCOMPRESSED = "5Kdc3UAwGmHHuj6fQD1LDmKR6J3SwYyFWyHgxKAZ2cKRzVCRETY";
//    protected static final String WIF_TEST_UNCOMPRESSED = "93QEdCzUrzMRsnbx2YuF6MsNjxQA6iWSrv9e2wX4NM4UmYzUsLn";
//
//    public interface ECBaseTest {
//
//        byte[] EC_TEST_SALT = "y²=x³+ax+b".getBytes(StandardCharsets.UTF_8);
//        byte[] EC_TEST_SEED = "₿ŁADΞ".getBytes(StandardCharsets.UTF_8);
//
//        String EC_TEST_M_PRIVATE_KEY_HEX = "e43c49058789854b9301ca8b16ad704560c7a4358f0142abe66321c892e5a5ce";
//        String EC_TEST_M_CHAIN_CODE_HEX = "423cc08937bb805095483925d7ceca7435e9a49e15293fa53ee79d5c910fc612";
//        String EC_TEST_M_COMPRESSED_PUBLIC_KEY_HEX = "0200da490e4f051c65ee2add1820dd928fd4094c641f008f5b78446c14321e4d8b";
//        String EC_TEST_M_UNCOMPRESSED_PUBLIC_KEY_HEX = "0400da490e4f051c65ee2add1820dd928fd4094c641f008f5b78446c14321e4d8b57fa0218d303864389d50aab13fe9501ca70ee2c1bcfc92af209f38a5a3cc2c2";
//
//        String EC_TEST_M_PUBLIC_KEY_HASH_160_HEX = "ceb7a5b0ab06186769bce7ba74910e381429eb0f";
//        byte[] EC_TEST_M_PUBLIC_KEY_HASH_160 = Hex.decode(EC_TEST_M_PUBLIC_KEY_HASH_160_HEX);
//
//        AddressContext EC_TEST_EMPTY_ADDRESS_CONTEXT = AddressContext.builder().build();
//
//        AddressContext EC_TEST_M_PUBLIC_KEY_ADDRESS_CONTEXT = AddressContext.builder()
//                .pubKey(Hex.decode(EC_TEST_M_COMPRESSED_PUBLIC_KEY_HEX))
//                .build();
//
//        AddressContext EC_TEST_M_PUBLIC_KEY_TEST_ADDRESS_CONTEXT = AddressContext.builder()
//                .pubKey(Hex.decode(EC_TEST_M_COMPRESSED_PUBLIC_KEY_HEX))
//                .testnet(true)
//                .build();
//
//        AddressContext EC_TEST_M_SEED_COMPRESSED_ADDRESS_CONTEXT = AddressContext.builder()
//                .seed(EC_TEST_SEED)
//                .compressed(true)
//                .build();
//
//        AddressContext EC_TEST_M_SEED_COMPRESSED_TEST_ADDRESS_CONTEXT = AddressContext.builder()
//                .seed(EC_TEST_SEED)
//                .testnet(true)
//                .compressed(true)
//                .build();
//
//        AddressContext EC_TEST_M_SEED_UNCOMPRESSED_ADDRESS_CONTEXT = AddressContext.builder()
//                .seed(EC_TEST_SEED)
//                .build();
//
//        AddressContext EC_TEST_M_SEED_UNCOMPRESSED_TEST_ADDRESS_CONTEXT = AddressContext.builder()
//                .seed(EC_TEST_SEED)
//                .testnet(true)
//                .build();
//
//        String EC_TEST_M_COMPRESSED_P2PKH_ADDRESS = "1Kr2CYuXN35vRB512zy7GHeMnEPGvC7pbJ";
//        String EC_TEST_M_COMPRESSED_P2PKH_TEST_ADDRESS = "mzMyVbzWB4XBCHYckZwV6CrgeDyyp9JUsm";
//
//        String EC_TEST_M_COMPRESSED_P2SH_ADDRESS = "3LY386PxuwQJWLmSA6dhgv1HvkfzSGZLtw";
//        String EC_TEST_M_COMPRESSED_P2SH_TEST_ADDRESS = "2NC6FBqKzXPuei8PyqEFaJrzZ96tAEypJb6";
//
//        String EC_TEST_M_UNCOMPRESSED_P2PKH_ADDRESS = "1FELGV7XmTZhT5v7ZeR4ve4R86iWF4anFS";
//        String EC_TEST_M_UNCOMPRESSED_P2PKH_TEST_ADDRESS = "mukHZYCWaUzxECPjHDPSkZGjz6KD9kUTqT";
//
//        String EC_TEST_M_UNCOMPRESSED_P2SH_ADDRESS = "3FvMC2byKMt5YFcYgk5fMGRMGd1DknNbPA";
//        String EC_TEST_M_UNCOMPRESSED_P2SH_TEST_ADDRESS = "2N7UZFmXzvpPRk3F6MshXyDQcUyDPXRDHaZ";
//    }
//
//    protected static void addressTest(AddressFormatter formatter, byte[] pubKey, String expectedFormat, String expectedAddress, boolean expectedTest) {
//
//        Address address = formatter.to(pubKey, expectedTest);
//        assertEquals(expectedFormat, address.getFormatType());
//        assertEquals(expectedAddress, address.getName());
//        assertEquals(expectedTest, address.isTestnet());
//    }
}
