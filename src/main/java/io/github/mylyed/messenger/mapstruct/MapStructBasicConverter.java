package io.github.mylyed.messenger.mapstruct;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mappings;

import java.util.List;

public interface MapStructBasicConverter<SOURCE, TARGET> {

    @Mappings({})
    @InheritConfiguration
    TARGET to(SOURCE source);

    @InheritConfiguration
    List<TARGET> toList(List<SOURCE> list);

    @InheritInverseConfiguration
    SOURCE from(TARGET target);

    @InheritInverseConfiguration
    List<SOURCE> fromList(List<TARGET> list);

}