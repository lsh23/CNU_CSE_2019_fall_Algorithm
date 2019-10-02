import math

def distance(point_pair):
    x1 = point_pair[0][0]
    y1 = point_pair[0][1]
    x2 = point_pair[1][0]
    y2 = point_pair[1][1]
    return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)

def min_distance_in_window(y_sorted_boundered_list,delta):
    min_distance = 1.7976931348623157e+308
    min_distance_pair = []
    for i in range(len(y_sorted_boundered_list)-1):
        point_one = y_sorted_boundered_list[i]
        for j in range(i+1,len(y_sorted_boundered_list)):
            point_two = y_sorted_boundered_list[j]
            if(abs(point_one[1] - point_two[1]) > delta):
                break
            else:
                tmp_pair = [point_one,point_two]
                tmp_distance = distance(tmp_pair)
                if (min_distance > tmp_distance ) :
                    min_distance = tmp_distance
                    min_distance_pair = tmp_pair

    return min_distance,min_distance_pair


def boundering_points_list_from_delta(points_list, delta):

    half_of_list = int(len(points_list)/2)
    half_x_point_of_list = points_list[half_of_list][0]
    boundered_list = [ point for point in points_list if (abs(point[0]-half_x_point_of_list) or point[0] == half_x_point_of_list) ]

    return boundered_list

def closest_pair_of_points(points_list):

    len_list = len(points_list)
    if(len_list ==3):
        point_one = points_list[0]
        point_two = points_list[1]
        point_three = points_list[2]
        distance_one_two = distance([point_one,point_two])
        distance_one_three = distance([point_one,point_three])
        distance_two_three = distance([point_two, point_three])
        index = min([distance_one_two,distance_one_three,distance_two_three])
        if(index==0): return [point_one,point_two]
        if(index==1): return [point_one,point_three]
        if(index==2): return [point_two,point_three]

    if(len_list ==2):
        return points_list
    # 3개 이하일때 브루트 포스

    l_closest_pair = closest_pair_of_points(points_list[:int(len_list/2)])
    r_closest_pair = closest_pair_of_points(points_list[int(len_list/2):])

    l_distance = distance(l_closest_pair)
    r_distance = distance(r_closest_pair)

    if(r_distance > l_distance):
        closest_pair_distance = l_distance
        closest_pair = l_closest_pair
    else:
        closest_pair_distance = r_distance
        closest_pair = r_closest_pair

    boundered_list = boundering_points_list_from_delta(points_list,closest_pair_distance)

    boundered_list.sort(key=lambda x:x[1])

    min_dist_in_window,min_dist_pair_in_window = min_distance_in_window(boundered_list, closest_pair_distance)

    if (closest_pair_distance < min_dist_in_window ):
        return closest_pair
    else:
        return min_dist_pair_in_window


def non_root_distance(point_pair):
    x1 = point_pair[0][0]
    y1 = point_pair[0][1]
    x2 = point_pair[1][0]
    y2 = point_pair[1][1]
    return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)


n = int(input())
point_list = []
for i in range(n):
    line = input().split(" ")
    x = int(line[0])
    y = int(line[1])
    point = (x,y)
    point_list.append(point)

# point_list = [(1.23,12.3),(1.0,2.0),(3.1,21.2),(5.2,10.0)]

point_list = list(set(point_list))

point_list.sort()

closest_pair = closest_pair_of_points(point_list)
# print(distance(closest_pair))
print(non_root_distance(closest_pair))