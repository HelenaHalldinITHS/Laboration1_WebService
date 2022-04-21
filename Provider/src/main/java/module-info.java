import org.example.converter.KiloConverter;
import org.example.provider.KiloToPoundsConverter;
import org.example.provider.KiloToStoneConverter;

module org.example.weightconversionprovider {
    requires org.example.converter;
    provides KiloConverter with KiloToPoundsConverter, KiloToStoneConverter;
}
