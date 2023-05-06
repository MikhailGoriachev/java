package org.itstep.pd011;

// Функциональный интерфейс для построения фабрики классов
@FunctionalInterface
public interface DemoClassBuilder {
    DemoClass create(String str);

    // реализация по умолчанию
    default DemoClass create(int param) { return  new DemoClass(param); }
} // interface DemoClassBuilder
