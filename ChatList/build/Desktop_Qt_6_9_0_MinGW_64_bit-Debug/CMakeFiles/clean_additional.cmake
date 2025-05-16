# Additional clean files
cmake_minimum_required(VERSION 3.16)

if("${CONFIG}" STREQUAL "" OR "${CONFIG}" STREQUAL "Debug")
  file(REMOVE_RECURSE
  "CMakeFiles\\ChatList_autogen.dir\\AutogenUsed.txt"
  "CMakeFiles\\ChatList_autogen.dir\\ParseCache.txt"
  "ChatList_autogen"
  )
endif()
