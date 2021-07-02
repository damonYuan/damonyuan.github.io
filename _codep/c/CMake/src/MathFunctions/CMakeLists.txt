# First the executable for MakeTable is added as any other executable would be added.
# Then we add a custom command that specifies how to produce Table.h by running MakeTable.
# Next we have to let CMake know that mysqrt.cxx depends on the generated file Table.h.
# This is done by adding the generated Table.h to the list of sources for the library MathFunctions.
# We also have to add the current binary directory to the list of include directories so that Table.h can
# be found and included by mysqrt.cxx. When this project is built it will first build the MakeTable executable.
# It will then run MakeTable to produce Table.h. Finally, it will compile mysqrt.cxx which includes Table.h to
# produce the MathFunctions library.

# first we add the executable that generates the table
add_executable(MakeTable MakeTable.cxx)

# add the command to generate the source code
add_custom_command (
        OUTPUT ${CMAKE_CURRENT_BINARY_DIR}/Table.h
        COMMAND MakeTable ${CMAKE_CURRENT_BINARY_DIR}/Table.h
        DEPENDS MakeTable
)

# add the binary tree directory to the search path for
# include files
include_directories( ${CMAKE_CURRENT_BINARY_DIR} )

# add the main library
add_library(MathFunctions mysqrt.cxx ${CMAKE_CURRENT_BINARY_DIR}/Table.h)

# setup the library and the header file to be installed by add
# the following two lines
install (TARGETS MathFunctions DESTINATION bin)
install (FILES MathFunctions.h DESTINATION include)

