project(discount_applier-spy-cmocka C)

add_cmocka_test(discount_applier_spy_test
        SOURCES test-discount_applier-spy.c
        LINK_LIBRARIES src cmocka-static)

add_cmocka_test_environment(discount_applier_spy_test)

set_property(TARGET
        discount_applier_spy_test
        PROPERTY
        LINK_FLAGS
        "${DEFAULT_LINK_FLAGS} -Wl,--wrap=notify_discount")

