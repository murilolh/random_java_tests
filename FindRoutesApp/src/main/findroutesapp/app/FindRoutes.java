package findroutesapp.app;

import java.util.*;

public class FindRoutes {
    private static final int ORIGIN = 0;
    private static final int DESTINY = 1;

    public static String findRoutes(List<ArrayList<String>> routes) {
        final Map<String, String> routeMap = generateMapOfRoutes(routes);
        final String origin = getOrigin(routeMap);

        return generateRouteString(routeMap, origin);
    }

    private static Map<String, String> generateMapOfRoutes(List<ArrayList<String>> routes) {
        final Map<String, String> routeMap = new HashMap<>();
        for (List<String> list : routes)
            routeMap.put(list.get(ORIGIN), list.get(DESTINY));
        return routeMap;
    }

    private static String getOrigin(Map<String, String> routeMap) {
        final Set<String> originSet = new HashSet<>(routeMap.keySet());
        final Set<String> destinySet = new HashSet<>(routeMap.values());
        originSet.removeAll(destinySet);

        if (originSet.size() != 1)
            throw new RuntimeException("Route is circular or has more than one origin.");

        return String.valueOf(originSet.toArray()[0]);
    }

    private static String generateRouteString(Map<String, String> routeMap, String origin) {
        final List<String> sortedRoute = new LinkedList<>();
        String currentOrigin = origin;
        sortedRoute.add(currentOrigin);
        while (!routeMap.isEmpty()) {
            String currentDestiny = routeMap.get(currentOrigin);
            sortedRoute.add(currentDestiny);

            routeMap.remove(currentOrigin);
            currentOrigin = currentDestiny;
        }
        return String.join(", ", sortedRoute);
    }
}
